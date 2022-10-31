/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit.jpa.kontroleri;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ispit.jpa.entity.Client;
import ispit.jpa.entity.ProductCart;
import ispit.jpa.entity.ShoppingCart;
import ispit.jpa.kontroleri.exceptions.IllegalOrphanException;
import ispit.jpa.kontroleri.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vikto
 */
public class ShoppingCartJpaController implements Serializable {

    public ShoppingCartJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ShoppingCart shoppingCart) {
        if (shoppingCart.getProductCartList() == null) {
            shoppingCart.setProductCartList(new ArrayList<ProductCart>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client clientId = shoppingCart.getClientId();
            if (clientId != null) {
                clientId = em.getReference(clientId.getClass(), clientId.getClientId());
                shoppingCart.setClientId(clientId);
            }
            List<ProductCart> attachedProductCartList = new ArrayList<ProductCart>();
            for (ProductCart productCartListProductCartToAttach : shoppingCart.getProductCartList()) {
                productCartListProductCartToAttach = em.getReference(productCartListProductCartToAttach.getClass(), productCartListProductCartToAttach.getProductCartPK());
                attachedProductCartList.add(productCartListProductCartToAttach);
            }
            shoppingCart.setProductCartList(attachedProductCartList);
            em.persist(shoppingCart);
            if (clientId != null) {
                clientId.getShoppingCartList().add(shoppingCart);
                clientId = em.merge(clientId);
            }
            for (ProductCart productCartListProductCart : shoppingCart.getProductCartList()) {
                ShoppingCart oldShoppingCartOfProductCartListProductCart = productCartListProductCart.getShoppingCart();
                productCartListProductCart.setShoppingCart(shoppingCart);
                productCartListProductCart = em.merge(productCartListProductCart);
                if (oldShoppingCartOfProductCartListProductCart != null) {
                    oldShoppingCartOfProductCartListProductCart.getProductCartList().remove(productCartListProductCart);
                    oldShoppingCartOfProductCartListProductCart = em.merge(oldShoppingCartOfProductCartListProductCart);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ShoppingCart shoppingCart) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ShoppingCart persistentShoppingCart = em.find(ShoppingCart.class, shoppingCart.getCartId());
            Client clientIdOld = persistentShoppingCart.getClientId();
            Client clientIdNew = shoppingCart.getClientId();
            List<ProductCart> productCartListOld = persistentShoppingCart.getProductCartList();
            List<ProductCart> productCartListNew = shoppingCart.getProductCartList();
            List<String> illegalOrphanMessages = null;
            for (ProductCart productCartListOldProductCart : productCartListOld) {
                if (!productCartListNew.contains(productCartListOldProductCart)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ProductCart " + productCartListOldProductCart + " since its shoppingCart field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clientIdNew != null) {
                clientIdNew = em.getReference(clientIdNew.getClass(), clientIdNew.getClientId());
                shoppingCart.setClientId(clientIdNew);
            }
            List<ProductCart> attachedProductCartListNew = new ArrayList<ProductCart>();
            for (ProductCart productCartListNewProductCartToAttach : productCartListNew) {
                productCartListNewProductCartToAttach = em.getReference(productCartListNewProductCartToAttach.getClass(), productCartListNewProductCartToAttach.getProductCartPK());
                attachedProductCartListNew.add(productCartListNewProductCartToAttach);
            }
            productCartListNew = attachedProductCartListNew;
            shoppingCart.setProductCartList(productCartListNew);
            shoppingCart = em.merge(shoppingCart);
            if (clientIdOld != null && !clientIdOld.equals(clientIdNew)) {
                clientIdOld.getShoppingCartList().remove(shoppingCart);
                clientIdOld = em.merge(clientIdOld);
            }
            if (clientIdNew != null && !clientIdNew.equals(clientIdOld)) {
                clientIdNew.getShoppingCartList().add(shoppingCart);
                clientIdNew = em.merge(clientIdNew);
            }
            for (ProductCart productCartListNewProductCart : productCartListNew) {
                if (!productCartListOld.contains(productCartListNewProductCart)) {
                    ShoppingCart oldShoppingCartOfProductCartListNewProductCart = productCartListNewProductCart.getShoppingCart();
                    productCartListNewProductCart.setShoppingCart(shoppingCart);
                    productCartListNewProductCart = em.merge(productCartListNewProductCart);
                    if (oldShoppingCartOfProductCartListNewProductCart != null && !oldShoppingCartOfProductCartListNewProductCart.equals(shoppingCart)) {
                        oldShoppingCartOfProductCartListNewProductCart.getProductCartList().remove(productCartListNewProductCart);
                        oldShoppingCartOfProductCartListNewProductCart = em.merge(oldShoppingCartOfProductCartListNewProductCart);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = shoppingCart.getCartId();
                if (findShoppingCart(id) == null) {
                    throw new NonexistentEntityException("The shoppingCart with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ShoppingCart shoppingCart;
            try {
                shoppingCart = em.getReference(ShoppingCart.class, id);
                shoppingCart.getCartId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shoppingCart with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ProductCart> productCartListOrphanCheck = shoppingCart.getProductCartList();
            for (ProductCart productCartListOrphanCheckProductCart : productCartListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ShoppingCart (" + shoppingCart + ") cannot be destroyed since the ProductCart " + productCartListOrphanCheckProductCart + " in its productCartList field has a non-nullable shoppingCart field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Client clientId = shoppingCart.getClientId();
            if (clientId != null) {
                clientId.getShoppingCartList().remove(shoppingCart);
                clientId = em.merge(clientId);
            }
            em.remove(shoppingCart);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ShoppingCart> findShoppingCartEntities() {
        return findShoppingCartEntities(true, -1, -1);
    }

    public List<ShoppingCart> findShoppingCartEntities(int maxResults, int firstResult) {
        return findShoppingCartEntities(false, maxResults, firstResult);
    }

    private List<ShoppingCart> findShoppingCartEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ShoppingCart.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ShoppingCart findShoppingCart(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ShoppingCart.class, id);
        } finally {
            em.close();
        }
    }

    public int getShoppingCartCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ShoppingCart> rt = cq.from(ShoppingCart.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

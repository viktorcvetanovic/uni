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
import ispit.jpa.entity.Product;
import ispit.jpa.entity.ProductCart;
import ispit.jpa.entity.ProductCartPK;
import ispit.jpa.entity.ShoppingCart;
import ispit.jpa.kontroleri.exceptions.NonexistentEntityException;
import ispit.jpa.kontroleri.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vikto
 */
public class ProductCartJpaController implements Serializable {

    public ProductCartJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductCart productCart) throws PreexistingEntityException, Exception {
        if (productCart.getProductCartPK() == null) {
            productCart.setProductCartPK(new ProductCartPK());
        }
        productCart.getProductCartPK().setProductId(productCart.getProduct().getProductId());
        productCart.getProductCartPK().setCartId(productCart.getShoppingCart().getCartId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product product = productCart.getProduct();
            if (product != null) {
                product = em.getReference(product.getClass(), product.getProductId());
                productCart.setProduct(product);
            }
            ShoppingCart shoppingCart = productCart.getShoppingCart();
            if (shoppingCart != null) {
                shoppingCart = em.getReference(shoppingCart.getClass(), shoppingCart.getCartId());
                productCart.setShoppingCart(shoppingCart);
            }
            em.persist(productCart);
            if (product != null) {
                product.getProductCartList().add(productCart);
                product = em.merge(product);
            }
            if (shoppingCart != null) {
                shoppingCart.getProductCartList().add(productCart);
                shoppingCart = em.merge(shoppingCart);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductCart(productCart.getProductCartPK()) != null) {
                throw new PreexistingEntityException("ProductCart " + productCart + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductCart productCart) throws NonexistentEntityException, Exception {
        productCart.getProductCartPK().setProductId(productCart.getProduct().getProductId());
        productCart.getProductCartPK().setCartId(productCart.getShoppingCart().getCartId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductCart persistentProductCart = em.find(ProductCart.class, productCart.getProductCartPK());
            Product productOld = persistentProductCart.getProduct();
            Product productNew = productCart.getProduct();
            ShoppingCart shoppingCartOld = persistentProductCart.getShoppingCart();
            ShoppingCart shoppingCartNew = productCart.getShoppingCart();
            if (productNew != null) {
                productNew = em.getReference(productNew.getClass(), productNew.getProductId());
                productCart.setProduct(productNew);
            }
            if (shoppingCartNew != null) {
                shoppingCartNew = em.getReference(shoppingCartNew.getClass(), shoppingCartNew.getCartId());
                productCart.setShoppingCart(shoppingCartNew);
            }
            productCart = em.merge(productCart);
            if (productOld != null && !productOld.equals(productNew)) {
                productOld.getProductCartList().remove(productCart);
                productOld = em.merge(productOld);
            }
            if (productNew != null && !productNew.equals(productOld)) {
                productNew.getProductCartList().add(productCart);
                productNew = em.merge(productNew);
            }
            if (shoppingCartOld != null && !shoppingCartOld.equals(shoppingCartNew)) {
                shoppingCartOld.getProductCartList().remove(productCart);
                shoppingCartOld = em.merge(shoppingCartOld);
            }
            if (shoppingCartNew != null && !shoppingCartNew.equals(shoppingCartOld)) {
                shoppingCartNew.getProductCartList().add(productCart);
                shoppingCartNew = em.merge(shoppingCartNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProductCartPK id = productCart.getProductCartPK();
                if (findProductCart(id) == null) {
                    throw new NonexistentEntityException("The productCart with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProductCartPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductCart productCart;
            try {
                productCart = em.getReference(ProductCart.class, id);
                productCart.getProductCartPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productCart with id " + id + " no longer exists.", enfe);
            }
            Product product = productCart.getProduct();
            if (product != null) {
                product.getProductCartList().remove(productCart);
                product = em.merge(product);
            }
            ShoppingCart shoppingCart = productCart.getShoppingCart();
            if (shoppingCart != null) {
                shoppingCart.getProductCartList().remove(productCart);
                shoppingCart = em.merge(shoppingCart);
            }
            em.remove(productCart);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductCart> findProductCartEntities() {
        return findProductCartEntities(true, -1, -1);
    }

    public List<ProductCart> findProductCartEntities(int maxResults, int firstResult) {
        return findProductCartEntities(false, maxResults, firstResult);
    }

    private List<ProductCart> findProductCartEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductCart.class));
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

    public ProductCart findProductCart(ProductCartPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductCart.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCartCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductCart> rt = cq.from(ProductCart.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

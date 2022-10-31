/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit.jpa.kontroleri;

import ispit.jpa.entity.Product;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ispit.jpa.entity.ProductCart;
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
public class ProductJpaController implements Serializable {

    public ProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Product product) {
        if (product.getProductCartList() == null) {
            product.setProductCartList(new ArrayList<ProductCart>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ProductCart> attachedProductCartList = new ArrayList<ProductCart>();
            for (ProductCart productCartListProductCartToAttach : product.getProductCartList()) {
                productCartListProductCartToAttach = em.getReference(productCartListProductCartToAttach.getClass(), productCartListProductCartToAttach.getProductCartPK());
                attachedProductCartList.add(productCartListProductCartToAttach);
            }
            product.setProductCartList(attachedProductCartList);
            em.persist(product);
            for (ProductCart productCartListProductCart : product.getProductCartList()) {
                Product oldProductOfProductCartListProductCart = productCartListProductCart.getProduct();
                productCartListProductCart.setProduct(product);
                productCartListProductCart = em.merge(productCartListProductCart);
                if (oldProductOfProductCartListProductCart != null) {
                    oldProductOfProductCartListProductCart.getProductCartList().remove(productCartListProductCart);
                    oldProductOfProductCartListProductCart = em.merge(oldProductOfProductCartListProductCart);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Product product) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product persistentProduct = em.find(Product.class, product.getProductId());
            List<ProductCart> productCartListOld = persistentProduct.getProductCartList();
            List<ProductCart> productCartListNew = product.getProductCartList();
            List<String> illegalOrphanMessages = null;
            for (ProductCart productCartListOldProductCart : productCartListOld) {
                if (!productCartListNew.contains(productCartListOldProductCart)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ProductCart " + productCartListOldProductCart + " since its product field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ProductCart> attachedProductCartListNew = new ArrayList<ProductCart>();
            for (ProductCart productCartListNewProductCartToAttach : productCartListNew) {
                productCartListNewProductCartToAttach = em.getReference(productCartListNewProductCartToAttach.getClass(), productCartListNewProductCartToAttach.getProductCartPK());
                attachedProductCartListNew.add(productCartListNewProductCartToAttach);
            }
            productCartListNew = attachedProductCartListNew;
            product.setProductCartList(productCartListNew);
            product = em.merge(product);
            for (ProductCart productCartListNewProductCart : productCartListNew) {
                if (!productCartListOld.contains(productCartListNewProductCart)) {
                    Product oldProductOfProductCartListNewProductCart = productCartListNewProductCart.getProduct();
                    productCartListNewProductCart.setProduct(product);
                    productCartListNewProductCart = em.merge(productCartListNewProductCart);
                    if (oldProductOfProductCartListNewProductCart != null && !oldProductOfProductCartListNewProductCart.equals(product)) {
                        oldProductOfProductCartListNewProductCart.getProductCartList().remove(productCartListNewProductCart);
                        oldProductOfProductCartListNewProductCart = em.merge(oldProductOfProductCartListNewProductCart);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = product.getProductId();
                if (findProduct(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
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
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ProductCart> productCartListOrphanCheck = product.getProductCartList();
            for (ProductCart productCartListOrphanCheckProductCart : productCartListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Product (" + product + ") cannot be destroyed since the ProductCart " + productCartListOrphanCheckProductCart + " in its productCartList field has a non-nullable product field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
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

    public Product findProduct(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Product> rt = cq.from(Product.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

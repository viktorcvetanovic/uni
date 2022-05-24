/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Productilnes;
import java.util.ArrayList;
import java.util.List;
import entity.OrderDetails;
import entity.Products;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class ProductsJpaController implements Serializable {

    public ProductsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Products products) throws RollbackFailureException, Exception {
        if (products.getProductilnesList() == null) {
            products.setProductilnesList(new ArrayList<Productilnes>());
        }
        if (products.getOrderDetailsList() == null) {
            products.setOrderDetailsList(new ArrayList<OrderDetails>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Productilnes> attachedProductilnesList = new ArrayList<Productilnes>();
            for (Productilnes productilnesListProductilnesToAttach : products.getProductilnesList()) {
                productilnesListProductilnesToAttach = em.getReference(productilnesListProductilnesToAttach.getClass(), productilnesListProductilnesToAttach.getProductLine());
                attachedProductilnesList.add(productilnesListProductilnesToAttach);
            }
            products.setProductilnesList(attachedProductilnesList);
            List<OrderDetails> attachedOrderDetailsList = new ArrayList<OrderDetails>();
            for (OrderDetails orderDetailsListOrderDetailsToAttach : products.getOrderDetailsList()) {
                orderDetailsListOrderDetailsToAttach = em.getReference(orderDetailsListOrderDetailsToAttach.getClass(), orderDetailsListOrderDetailsToAttach.getDetailsId());
                attachedOrderDetailsList.add(orderDetailsListOrderDetailsToAttach);
            }
            products.setOrderDetailsList(attachedOrderDetailsList);
            em.persist(products);
            for (Productilnes productilnesListProductilnes : products.getProductilnesList()) {
                Products oldCodeOfProductilnesListProductilnes = productilnesListProductilnes.getCode();
                productilnesListProductilnes.setCode(products);
                productilnesListProductilnes = em.merge(productilnesListProductilnes);
                if (oldCodeOfProductilnesListProductilnes != null) {
                    oldCodeOfProductilnesListProductilnes.getProductilnesList().remove(productilnesListProductilnes);
                    oldCodeOfProductilnesListProductilnes = em.merge(oldCodeOfProductilnesListProductilnes);
                }
            }
            for (OrderDetails orderDetailsListOrderDetails : products.getOrderDetailsList()) {
                Products oldCodeOfOrderDetailsListOrderDetails = orderDetailsListOrderDetails.getCode();
                orderDetailsListOrderDetails.setCode(products);
                orderDetailsListOrderDetails = em.merge(orderDetailsListOrderDetails);
                if (oldCodeOfOrderDetailsListOrderDetails != null) {
                    oldCodeOfOrderDetailsListOrderDetails.getOrderDetailsList().remove(orderDetailsListOrderDetails);
                    oldCodeOfOrderDetailsListOrderDetails = em.merge(oldCodeOfOrderDetailsListOrderDetails);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Products products) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Products persistentProducts = em.find(Products.class, products.getCode());
            List<Productilnes> productilnesListOld = persistentProducts.getProductilnesList();
            List<Productilnes> productilnesListNew = products.getProductilnesList();
            List<OrderDetails> orderDetailsListOld = persistentProducts.getOrderDetailsList();
            List<OrderDetails> orderDetailsListNew = products.getOrderDetailsList();
            List<String> illegalOrphanMessages = null;
            for (Productilnes productilnesListOldProductilnes : productilnesListOld) {
                if (!productilnesListNew.contains(productilnesListOldProductilnes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Productilnes " + productilnesListOldProductilnes + " since its code field is not nullable.");
                }
            }
            for (OrderDetails orderDetailsListOldOrderDetails : orderDetailsListOld) {
                if (!orderDetailsListNew.contains(orderDetailsListOldOrderDetails)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OrderDetails " + orderDetailsListOldOrderDetails + " since its code field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Productilnes> attachedProductilnesListNew = new ArrayList<Productilnes>();
            for (Productilnes productilnesListNewProductilnesToAttach : productilnesListNew) {
                productilnesListNewProductilnesToAttach = em.getReference(productilnesListNewProductilnesToAttach.getClass(), productilnesListNewProductilnesToAttach.getProductLine());
                attachedProductilnesListNew.add(productilnesListNewProductilnesToAttach);
            }
            productilnesListNew = attachedProductilnesListNew;
            products.setProductilnesList(productilnesListNew);
            List<OrderDetails> attachedOrderDetailsListNew = new ArrayList<OrderDetails>();
            for (OrderDetails orderDetailsListNewOrderDetailsToAttach : orderDetailsListNew) {
                orderDetailsListNewOrderDetailsToAttach = em.getReference(orderDetailsListNewOrderDetailsToAttach.getClass(), orderDetailsListNewOrderDetailsToAttach.getDetailsId());
                attachedOrderDetailsListNew.add(orderDetailsListNewOrderDetailsToAttach);
            }
            orderDetailsListNew = attachedOrderDetailsListNew;
            products.setOrderDetailsList(orderDetailsListNew);
            products = em.merge(products);
            for (Productilnes productilnesListNewProductilnes : productilnesListNew) {
                if (!productilnesListOld.contains(productilnesListNewProductilnes)) {
                    Products oldCodeOfProductilnesListNewProductilnes = productilnesListNewProductilnes.getCode();
                    productilnesListNewProductilnes.setCode(products);
                    productilnesListNewProductilnes = em.merge(productilnesListNewProductilnes);
                    if (oldCodeOfProductilnesListNewProductilnes != null && !oldCodeOfProductilnesListNewProductilnes.equals(products)) {
                        oldCodeOfProductilnesListNewProductilnes.getProductilnesList().remove(productilnesListNewProductilnes);
                        oldCodeOfProductilnesListNewProductilnes = em.merge(oldCodeOfProductilnesListNewProductilnes);
                    }
                }
            }
            for (OrderDetails orderDetailsListNewOrderDetails : orderDetailsListNew) {
                if (!orderDetailsListOld.contains(orderDetailsListNewOrderDetails)) {
                    Products oldCodeOfOrderDetailsListNewOrderDetails = orderDetailsListNewOrderDetails.getCode();
                    orderDetailsListNewOrderDetails.setCode(products);
                    orderDetailsListNewOrderDetails = em.merge(orderDetailsListNewOrderDetails);
                    if (oldCodeOfOrderDetailsListNewOrderDetails != null && !oldCodeOfOrderDetailsListNewOrderDetails.equals(products)) {
                        oldCodeOfOrderDetailsListNewOrderDetails.getOrderDetailsList().remove(orderDetailsListNewOrderDetails);
                        oldCodeOfOrderDetailsListNewOrderDetails = em.merge(oldCodeOfOrderDetailsListNewOrderDetails);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = products.getCode();
                if (findProducts(id) == null) {
                    throw new NonexistentEntityException("The products with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Products products;
            try {
                products = em.getReference(Products.class, id);
                products.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The products with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Productilnes> productilnesListOrphanCheck = products.getProductilnesList();
            for (Productilnes productilnesListOrphanCheckProductilnes : productilnesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Products (" + products + ") cannot be destroyed since the Productilnes " + productilnesListOrphanCheckProductilnes + " in its productilnesList field has a non-nullable code field.");
            }
            List<OrderDetails> orderDetailsListOrphanCheck = products.getOrderDetailsList();
            for (OrderDetails orderDetailsListOrphanCheckOrderDetails : orderDetailsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Products (" + products + ") cannot be destroyed since the OrderDetails " + orderDetailsListOrphanCheckOrderDetails + " in its orderDetailsList field has a non-nullable code field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(products);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Products> findProductsEntities() {
        return findProductsEntities(true, -1, -1);
    }

    public List<Products> findProductsEntities(int maxResults, int firstResult) {
        return findProductsEntities(false, maxResults, firstResult);
    }

    private List<Products> findProductsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Products.class));
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

    public Products findProducts(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Products.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Products> rt = cq.from(Products.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

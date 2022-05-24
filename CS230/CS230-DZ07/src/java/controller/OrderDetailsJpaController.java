/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import entity.OrderDetails;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Orders;
import entity.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class OrderDetailsJpaController implements Serializable {

    public OrderDetailsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrderDetails orderDetails) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orders orderNumber = orderDetails.getOrderNumber();
            if (orderNumber != null) {
                orderNumber = em.getReference(orderNumber.getClass(), orderNumber.getOrder());
                orderDetails.setOrderNumber(orderNumber);
            }
            Products code = orderDetails.getCode();
            if (code != null) {
                code = em.getReference(code.getClass(), code.getCode());
                orderDetails.setCode(code);
            }
            em.persist(orderDetails);
            if (orderNumber != null) {
                orderNumber.getOrderDetailsList().add(orderDetails);
                orderNumber = em.merge(orderNumber);
            }
            if (code != null) {
                code.getOrderDetailsList().add(orderDetails);
                code = em.merge(code);
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

    public void edit(OrderDetails orderDetails) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            OrderDetails persistentOrderDetails = em.find(OrderDetails.class, orderDetails.getDetailsId());
            Orders orderNumberOld = persistentOrderDetails.getOrderNumber();
            Orders orderNumberNew = orderDetails.getOrderNumber();
            Products codeOld = persistentOrderDetails.getCode();
            Products codeNew = orderDetails.getCode();
            if (orderNumberNew != null) {
                orderNumberNew = em.getReference(orderNumberNew.getClass(), orderNumberNew.getOrder());
                orderDetails.setOrderNumber(orderNumberNew);
            }
            if (codeNew != null) {
                codeNew = em.getReference(codeNew.getClass(), codeNew.getCode());
                orderDetails.setCode(codeNew);
            }
            orderDetails = em.merge(orderDetails);
            if (orderNumberOld != null && !orderNumberOld.equals(orderNumberNew)) {
                orderNumberOld.getOrderDetailsList().remove(orderDetails);
                orderNumberOld = em.merge(orderNumberOld);
            }
            if (orderNumberNew != null && !orderNumberNew.equals(orderNumberOld)) {
                orderNumberNew.getOrderDetailsList().add(orderDetails);
                orderNumberNew = em.merge(orderNumberNew);
            }
            if (codeOld != null && !codeOld.equals(codeNew)) {
                codeOld.getOrderDetailsList().remove(orderDetails);
                codeOld = em.merge(codeOld);
            }
            if (codeNew != null && !codeNew.equals(codeOld)) {
                codeNew.getOrderDetailsList().add(orderDetails);
                codeNew = em.merge(codeNew);
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
                Integer id = orderDetails.getDetailsId();
                if (findOrderDetails(id) == null) {
                    throw new NonexistentEntityException("The orderDetails with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            OrderDetails orderDetails;
            try {
                orderDetails = em.getReference(OrderDetails.class, id);
                orderDetails.getDetailsId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderDetails with id " + id + " no longer exists.", enfe);
            }
            Orders orderNumber = orderDetails.getOrderNumber();
            if (orderNumber != null) {
                orderNumber.getOrderDetailsList().remove(orderDetails);
                orderNumber = em.merge(orderNumber);
            }
            Products code = orderDetails.getCode();
            if (code != null) {
                code.getOrderDetailsList().remove(orderDetails);
                code = em.merge(code);
            }
            em.remove(orderDetails);
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

    public List<OrderDetails> findOrderDetailsEntities() {
        return findOrderDetailsEntities(true, -1, -1);
    }

    public List<OrderDetails> findOrderDetailsEntities(int maxResults, int firstResult) {
        return findOrderDetailsEntities(false, maxResults, firstResult);
    }

    private List<OrderDetails> findOrderDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrderDetails.class));
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

    public OrderDetails findOrderDetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrderDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrderDetails> rt = cq.from(OrderDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

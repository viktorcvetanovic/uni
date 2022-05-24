/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.OrderDetails;
import entity.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class OrdersJpaController implements Serializable {

    public OrdersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orders orders) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (orders.getOrderDetailsList() == null) {
            orders.setOrderDetailsList(new ArrayList<OrderDetails>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<OrderDetails> attachedOrderDetailsList = new ArrayList<OrderDetails>();
            for (OrderDetails orderDetailsListOrderDetailsToAttach : orders.getOrderDetailsList()) {
                orderDetailsListOrderDetailsToAttach = em.getReference(orderDetailsListOrderDetailsToAttach.getClass(), orderDetailsListOrderDetailsToAttach.getDetailsId());
                attachedOrderDetailsList.add(orderDetailsListOrderDetailsToAttach);
            }
            orders.setOrderDetailsList(attachedOrderDetailsList);
            em.persist(orders);
            for (OrderDetails orderDetailsListOrderDetails : orders.getOrderDetailsList()) {
                Orders oldOrderNumberOfOrderDetailsListOrderDetails = orderDetailsListOrderDetails.getOrderNumber();
                orderDetailsListOrderDetails.setOrderNumber(orders);
                orderDetailsListOrderDetails = em.merge(orderDetailsListOrderDetails);
                if (oldOrderNumberOfOrderDetailsListOrderDetails != null) {
                    oldOrderNumberOfOrderDetailsListOrderDetails.getOrderDetailsList().remove(orderDetailsListOrderDetails);
                    oldOrderNumberOfOrderDetailsListOrderDetails = em.merge(oldOrderNumberOfOrderDetailsListOrderDetails);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOrders(orders.getOrder()) != null) {
                throw new PreexistingEntityException("Orders " + orders + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orders orders) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Orders persistentOrders = em.find(Orders.class, orders.getOrder());
            List<OrderDetails> orderDetailsListOld = persistentOrders.getOrderDetailsList();
            List<OrderDetails> orderDetailsListNew = orders.getOrderDetailsList();
            List<String> illegalOrphanMessages = null;
            for (OrderDetails orderDetailsListOldOrderDetails : orderDetailsListOld) {
                if (!orderDetailsListNew.contains(orderDetailsListOldOrderDetails)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OrderDetails " + orderDetailsListOldOrderDetails + " since its orderNumber field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<OrderDetails> attachedOrderDetailsListNew = new ArrayList<OrderDetails>();
            for (OrderDetails orderDetailsListNewOrderDetailsToAttach : orderDetailsListNew) {
                orderDetailsListNewOrderDetailsToAttach = em.getReference(orderDetailsListNewOrderDetailsToAttach.getClass(), orderDetailsListNewOrderDetailsToAttach.getDetailsId());
                attachedOrderDetailsListNew.add(orderDetailsListNewOrderDetailsToAttach);
            }
            orderDetailsListNew = attachedOrderDetailsListNew;
            orders.setOrderDetailsList(orderDetailsListNew);
            orders = em.merge(orders);
            for (OrderDetails orderDetailsListNewOrderDetails : orderDetailsListNew) {
                if (!orderDetailsListOld.contains(orderDetailsListNewOrderDetails)) {
                    Orders oldOrderNumberOfOrderDetailsListNewOrderDetails = orderDetailsListNewOrderDetails.getOrderNumber();
                    orderDetailsListNewOrderDetails.setOrderNumber(orders);
                    orderDetailsListNewOrderDetails = em.merge(orderDetailsListNewOrderDetails);
                    if (oldOrderNumberOfOrderDetailsListNewOrderDetails != null && !oldOrderNumberOfOrderDetailsListNewOrderDetails.equals(orders)) {
                        oldOrderNumberOfOrderDetailsListNewOrderDetails.getOrderDetailsList().remove(orderDetailsListNewOrderDetails);
                        oldOrderNumberOfOrderDetailsListNewOrderDetails = em.merge(oldOrderNumberOfOrderDetailsListNewOrderDetails);
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
                Integer id = orders.getOrder();
                if (findOrders(id) == null) {
                    throw new NonexistentEntityException("The orders with id " + id + " no longer exists.");
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
            Orders orders;
            try {
                orders = em.getReference(Orders.class, id);
                orders.getOrder();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orders with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<OrderDetails> orderDetailsListOrphanCheck = orders.getOrderDetailsList();
            for (OrderDetails orderDetailsListOrphanCheckOrderDetails : orderDetailsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Orders (" + orders + ") cannot be destroyed since the OrderDetails " + orderDetailsListOrphanCheckOrderDetails + " in its orderDetailsList field has a non-nullable orderNumber field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(orders);
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

    public List<Orders> findOrdersEntities() {
        return findOrdersEntities(true, -1, -1);
    }

    public List<Orders> findOrdersEntities(int maxResults, int firstResult) {
        return findOrdersEntities(false, maxResults, firstResult);
    }

    private List<Orders> findOrdersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orders.class));
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

    public Orders findOrders(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orders.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orders> rt = cq.from(Orders.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import entity.Customers;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Payments;
import java.util.ArrayList;
import java.util.List;
import entity.Employees;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class CustomersJpaController implements Serializable {

    public CustomersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customers customers) throws RollbackFailureException, Exception {
        if (customers.getPaymentsList() == null) {
            customers.setPaymentsList(new ArrayList<Payments>());
        }
        if (customers.getEmployeesList() == null) {
            customers.setEmployeesList(new ArrayList<Employees>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Payments> attachedPaymentsList = new ArrayList<Payments>();
            for (Payments paymentsListPaymentsToAttach : customers.getPaymentsList()) {
                paymentsListPaymentsToAttach = em.getReference(paymentsListPaymentsToAttach.getClass(), paymentsListPaymentsToAttach.getCheckNumber());
                attachedPaymentsList.add(paymentsListPaymentsToAttach);
            }
            customers.setPaymentsList(attachedPaymentsList);
            List<Employees> attachedEmployeesList = new ArrayList<Employees>();
            for (Employees employeesListEmployeesToAttach : customers.getEmployeesList()) {
                employeesListEmployeesToAttach = em.getReference(employeesListEmployeesToAttach.getClass(), employeesListEmployeesToAttach.getEmployeeNumber());
                attachedEmployeesList.add(employeesListEmployeesToAttach);
            }
            customers.setEmployeesList(attachedEmployeesList);
            em.persist(customers);
            for (Payments paymentsListPayments : customers.getPaymentsList()) {
                Customers oldCustomerNumberOfPaymentsListPayments = paymentsListPayments.getCustomerNumber();
                paymentsListPayments.setCustomerNumber(customers);
                paymentsListPayments = em.merge(paymentsListPayments);
                if (oldCustomerNumberOfPaymentsListPayments != null) {
                    oldCustomerNumberOfPaymentsListPayments.getPaymentsList().remove(paymentsListPayments);
                    oldCustomerNumberOfPaymentsListPayments = em.merge(oldCustomerNumberOfPaymentsListPayments);
                }
            }
            for (Employees employeesListEmployees : customers.getEmployeesList()) {
                Customers oldCustomerNumberOfEmployeesListEmployees = employeesListEmployees.getCustomerNumber();
                employeesListEmployees.setCustomerNumber(customers);
                employeesListEmployees = em.merge(employeesListEmployees);
                if (oldCustomerNumberOfEmployeesListEmployees != null) {
                    oldCustomerNumberOfEmployeesListEmployees.getEmployeesList().remove(employeesListEmployees);
                    oldCustomerNumberOfEmployeesListEmployees = em.merge(oldCustomerNumberOfEmployeesListEmployees);
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

    public void edit(Customers customers) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Customers persistentCustomers = em.find(Customers.class, customers.getCustomerNumber());
            List<Payments> paymentsListOld = persistentCustomers.getPaymentsList();
            List<Payments> paymentsListNew = customers.getPaymentsList();
            List<Employees> employeesListOld = persistentCustomers.getEmployeesList();
            List<Employees> employeesListNew = customers.getEmployeesList();
            List<String> illegalOrphanMessages = null;
            for (Payments paymentsListOldPayments : paymentsListOld) {
                if (!paymentsListNew.contains(paymentsListOldPayments)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Payments " + paymentsListOldPayments + " since its customerNumber field is not nullable.");
                }
            }
            for (Employees employeesListOldEmployees : employeesListOld) {
                if (!employeesListNew.contains(employeesListOldEmployees)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Employees " + employeesListOldEmployees + " since its customerNumber field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Payments> attachedPaymentsListNew = new ArrayList<Payments>();
            for (Payments paymentsListNewPaymentsToAttach : paymentsListNew) {
                paymentsListNewPaymentsToAttach = em.getReference(paymentsListNewPaymentsToAttach.getClass(), paymentsListNewPaymentsToAttach.getCheckNumber());
                attachedPaymentsListNew.add(paymentsListNewPaymentsToAttach);
            }
            paymentsListNew = attachedPaymentsListNew;
            customers.setPaymentsList(paymentsListNew);
            List<Employees> attachedEmployeesListNew = new ArrayList<Employees>();
            for (Employees employeesListNewEmployeesToAttach : employeesListNew) {
                employeesListNewEmployeesToAttach = em.getReference(employeesListNewEmployeesToAttach.getClass(), employeesListNewEmployeesToAttach.getEmployeeNumber());
                attachedEmployeesListNew.add(employeesListNewEmployeesToAttach);
            }
            employeesListNew = attachedEmployeesListNew;
            customers.setEmployeesList(employeesListNew);
            customers = em.merge(customers);
            for (Payments paymentsListNewPayments : paymentsListNew) {
                if (!paymentsListOld.contains(paymentsListNewPayments)) {
                    Customers oldCustomerNumberOfPaymentsListNewPayments = paymentsListNewPayments.getCustomerNumber();
                    paymentsListNewPayments.setCustomerNumber(customers);
                    paymentsListNewPayments = em.merge(paymentsListNewPayments);
                    if (oldCustomerNumberOfPaymentsListNewPayments != null && !oldCustomerNumberOfPaymentsListNewPayments.equals(customers)) {
                        oldCustomerNumberOfPaymentsListNewPayments.getPaymentsList().remove(paymentsListNewPayments);
                        oldCustomerNumberOfPaymentsListNewPayments = em.merge(oldCustomerNumberOfPaymentsListNewPayments);
                    }
                }
            }
            for (Employees employeesListNewEmployees : employeesListNew) {
                if (!employeesListOld.contains(employeesListNewEmployees)) {
                    Customers oldCustomerNumberOfEmployeesListNewEmployees = employeesListNewEmployees.getCustomerNumber();
                    employeesListNewEmployees.setCustomerNumber(customers);
                    employeesListNewEmployees = em.merge(employeesListNewEmployees);
                    if (oldCustomerNumberOfEmployeesListNewEmployees != null && !oldCustomerNumberOfEmployeesListNewEmployees.equals(customers)) {
                        oldCustomerNumberOfEmployeesListNewEmployees.getEmployeesList().remove(employeesListNewEmployees);
                        oldCustomerNumberOfEmployeesListNewEmployees = em.merge(oldCustomerNumberOfEmployeesListNewEmployees);
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
                Integer id = customers.getCustomerNumber();
                if (findCustomers(id) == null) {
                    throw new NonexistentEntityException("The customers with id " + id + " no longer exists.");
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
            Customers customers;
            try {
                customers = em.getReference(Customers.class, id);
                customers.getCustomerNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customers with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Payments> paymentsListOrphanCheck = customers.getPaymentsList();
            for (Payments paymentsListOrphanCheckPayments : paymentsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Customers (" + customers + ") cannot be destroyed since the Payments " + paymentsListOrphanCheckPayments + " in its paymentsList field has a non-nullable customerNumber field.");
            }
            List<Employees> employeesListOrphanCheck = customers.getEmployeesList();
            for (Employees employeesListOrphanCheckEmployees : employeesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Customers (" + customers + ") cannot be destroyed since the Employees " + employeesListOrphanCheckEmployees + " in its employeesList field has a non-nullable customerNumber field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(customers);
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

    public List<Customers> findCustomersEntities() {
        return findCustomersEntities(true, -1, -1);
    }

    public List<Customers> findCustomersEntities(int maxResults, int firstResult) {
        return findCustomersEntities(false, maxResults, firstResult);
    }

    private List<Customers> findCustomersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customers.class));
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

    public Customers findCustomers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customers.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customers> rt = cq.from(Customers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

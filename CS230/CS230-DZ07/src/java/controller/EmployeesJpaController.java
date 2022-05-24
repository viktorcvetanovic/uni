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
import entity.Customers;
import entity.Employees;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class EmployeesJpaController implements Serializable {

    public EmployeesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Employees employees) throws RollbackFailureException, Exception {
        if (employees.getEmployeesList() == null) {
            employees.setEmployeesList(new ArrayList<Employees>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Customers customerNumber = employees.getCustomerNumber();
            if (customerNumber != null) {
                customerNumber = em.getReference(customerNumber.getClass(), customerNumber.getCustomerNumber());
                employees.setCustomerNumber(customerNumber);
            }
            Employees parentEmployee = employees.getParentEmployee();
            if (parentEmployee != null) {
                parentEmployee = em.getReference(parentEmployee.getClass(), parentEmployee.getEmployeeNumber());
                employees.setParentEmployee(parentEmployee);
            }
            List<Employees> attachedEmployeesList = new ArrayList<Employees>();
            for (Employees employeesListEmployeesToAttach : employees.getEmployeesList()) {
                employeesListEmployeesToAttach = em.getReference(employeesListEmployeesToAttach.getClass(), employeesListEmployeesToAttach.getEmployeeNumber());
                attachedEmployeesList.add(employeesListEmployeesToAttach);
            }
            employees.setEmployeesList(attachedEmployeesList);
            em.persist(employees);
            if (customerNumber != null) {
                customerNumber.getEmployeesList().add(employees);
                customerNumber = em.merge(customerNumber);
            }
            if (parentEmployee != null) {
                parentEmployee.getEmployeesList().add(employees);
                parentEmployee = em.merge(parentEmployee);
            }
            for (Employees employeesListEmployees : employees.getEmployeesList()) {
                Employees oldParentEmployeeOfEmployeesListEmployees = employeesListEmployees.getParentEmployee();
                employeesListEmployees.setParentEmployee(employees);
                employeesListEmployees = em.merge(employeesListEmployees);
                if (oldParentEmployeeOfEmployeesListEmployees != null) {
                    oldParentEmployeeOfEmployeesListEmployees.getEmployeesList().remove(employeesListEmployees);
                    oldParentEmployeeOfEmployeesListEmployees = em.merge(oldParentEmployeeOfEmployeesListEmployees);
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

    public void edit(Employees employees) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Employees persistentEmployees = em.find(Employees.class, employees.getEmployeeNumber());
            Customers customerNumberOld = persistentEmployees.getCustomerNumber();
            Customers customerNumberNew = employees.getCustomerNumber();
            Employees parentEmployeeOld = persistentEmployees.getParentEmployee();
            Employees parentEmployeeNew = employees.getParentEmployee();
            List<Employees> employeesListOld = persistentEmployees.getEmployeesList();
            List<Employees> employeesListNew = employees.getEmployeesList();
            List<String> illegalOrphanMessages = null;
            for (Employees employeesListOldEmployees : employeesListOld) {
                if (!employeesListNew.contains(employeesListOldEmployees)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Employees " + employeesListOldEmployees + " since its parentEmployee field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (customerNumberNew != null) {
                customerNumberNew = em.getReference(customerNumberNew.getClass(), customerNumberNew.getCustomerNumber());
                employees.setCustomerNumber(customerNumberNew);
            }
            if (parentEmployeeNew != null) {
                parentEmployeeNew = em.getReference(parentEmployeeNew.getClass(), parentEmployeeNew.getEmployeeNumber());
                employees.setParentEmployee(parentEmployeeNew);
            }
            List<Employees> attachedEmployeesListNew = new ArrayList<Employees>();
            for (Employees employeesListNewEmployeesToAttach : employeesListNew) {
                employeesListNewEmployeesToAttach = em.getReference(employeesListNewEmployeesToAttach.getClass(), employeesListNewEmployeesToAttach.getEmployeeNumber());
                attachedEmployeesListNew.add(employeesListNewEmployeesToAttach);
            }
            employeesListNew = attachedEmployeesListNew;
            employees.setEmployeesList(employeesListNew);
            employees = em.merge(employees);
            if (customerNumberOld != null && !customerNumberOld.equals(customerNumberNew)) {
                customerNumberOld.getEmployeesList().remove(employees);
                customerNumberOld = em.merge(customerNumberOld);
            }
            if (customerNumberNew != null && !customerNumberNew.equals(customerNumberOld)) {
                customerNumberNew.getEmployeesList().add(employees);
                customerNumberNew = em.merge(customerNumberNew);
            }
            if (parentEmployeeOld != null && !parentEmployeeOld.equals(parentEmployeeNew)) {
                parentEmployeeOld.getEmployeesList().remove(employees);
                parentEmployeeOld = em.merge(parentEmployeeOld);
            }
            if (parentEmployeeNew != null && !parentEmployeeNew.equals(parentEmployeeOld)) {
                parentEmployeeNew.getEmployeesList().add(employees);
                parentEmployeeNew = em.merge(parentEmployeeNew);
            }
            for (Employees employeesListNewEmployees : employeesListNew) {
                if (!employeesListOld.contains(employeesListNewEmployees)) {
                    Employees oldParentEmployeeOfEmployeesListNewEmployees = employeesListNewEmployees.getParentEmployee();
                    employeesListNewEmployees.setParentEmployee(employees);
                    employeesListNewEmployees = em.merge(employeesListNewEmployees);
                    if (oldParentEmployeeOfEmployeesListNewEmployees != null && !oldParentEmployeeOfEmployeesListNewEmployees.equals(employees)) {
                        oldParentEmployeeOfEmployeesListNewEmployees.getEmployeesList().remove(employeesListNewEmployees);
                        oldParentEmployeeOfEmployeesListNewEmployees = em.merge(oldParentEmployeeOfEmployeesListNewEmployees);
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
                Integer id = employees.getEmployeeNumber();
                if (findEmployees(id) == null) {
                    throw new NonexistentEntityException("The employees with id " + id + " no longer exists.");
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
            Employees employees;
            try {
                employees = em.getReference(Employees.class, id);
                employees.getEmployeeNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employees with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Employees> employeesListOrphanCheck = employees.getEmployeesList();
            for (Employees employeesListOrphanCheckEmployees : employeesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Employees (" + employees + ") cannot be destroyed since the Employees " + employeesListOrphanCheckEmployees + " in its employeesList field has a non-nullable parentEmployee field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Customers customerNumber = employees.getCustomerNumber();
            if (customerNumber != null) {
                customerNumber.getEmployeesList().remove(employees);
                customerNumber = em.merge(customerNumber);
            }
            Employees parentEmployee = employees.getParentEmployee();
            if (parentEmployee != null) {
                parentEmployee.getEmployeesList().remove(employees);
                parentEmployee = em.merge(parentEmployee);
            }
            em.remove(employees);
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

    public List<Employees> findEmployeesEntities() {
        return findEmployeesEntities(true, -1, -1);
    }

    public List<Employees> findEmployeesEntities(int maxResults, int firstResult) {
        return findEmployeesEntities(false, maxResults, firstResult);
    }

    private List<Employees> findEmployeesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employees.class));
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

    public Employees findEmployees(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employees.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employees> rt = cq.from(Employees.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

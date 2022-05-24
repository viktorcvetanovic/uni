/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import entity.Productilnes;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author BiG
 */
public class ProductilnesJpaController implements Serializable {

    public ProductilnesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productilnes productilnes) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Products code = productilnes.getCode();
            if (code != null) {
                code = em.getReference(code.getClass(), code.getCode());
                productilnes.setCode(code);
            }
            em.persist(productilnes);
            if (code != null) {
                code.getProductilnesList().add(productilnes);
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

    public void edit(Productilnes productilnes) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Productilnes persistentProductilnes = em.find(Productilnes.class, productilnes.getProductLine());
            Products codeOld = persistentProductilnes.getCode();
            Products codeNew = productilnes.getCode();
            if (codeNew != null) {
                codeNew = em.getReference(codeNew.getClass(), codeNew.getCode());
                productilnes.setCode(codeNew);
            }
            productilnes = em.merge(productilnes);
            if (codeOld != null && !codeOld.equals(codeNew)) {
                codeOld.getProductilnesList().remove(productilnes);
                codeOld = em.merge(codeOld);
            }
            if (codeNew != null && !codeNew.equals(codeOld)) {
                codeNew.getProductilnesList().add(productilnes);
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
                Integer id = productilnes.getProductLine();
                if (findProductilnes(id) == null) {
                    throw new NonexistentEntityException("The productilnes with id " + id + " no longer exists.");
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
            Productilnes productilnes;
            try {
                productilnes = em.getReference(Productilnes.class, id);
                productilnes.getProductLine();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productilnes with id " + id + " no longer exists.", enfe);
            }
            Products code = productilnes.getCode();
            if (code != null) {
                code.getProductilnesList().remove(productilnes);
                code = em.merge(code);
            }
            em.remove(productilnes);
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

    public List<Productilnes> findProductilnesEntities() {
        return findProductilnesEntities(true, -1, -1);
    }

    public List<Productilnes> findProductilnesEntities(int maxResults, int firstResult) {
        return findProductilnesEntities(false, maxResults, firstResult);
    }

    private List<Productilnes> findProductilnesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productilnes.class));
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

    public Productilnes findProductilnes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productilnes.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductilnesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productilnes> rt = cq.from(Productilnes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

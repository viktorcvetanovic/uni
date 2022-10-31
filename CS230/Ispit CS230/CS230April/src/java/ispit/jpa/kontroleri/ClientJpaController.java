/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit.jpa.kontroleri;

import ispit.jpa.entity.Client;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ispit.jpa.entity.Role;
import ispit.jpa.entity.ShoppingCart;
import ispit.jpa.kontroleri.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vikto
 */
public class ClientJpaController implements Serializable {

    public ClientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Client client) {
        if (client.getShoppingCartList() == null) {
            client.setShoppingCartList(new ArrayList<ShoppingCart>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Role roleId = client.getRoleId();
            if (roleId != null) {
                roleId = em.getReference(roleId.getClass(), roleId.getRoleId());
                client.setRoleId(roleId);
            }
            List<ShoppingCart> attachedShoppingCartList = new ArrayList<ShoppingCart>();
            for (ShoppingCart shoppingCartListShoppingCartToAttach : client.getShoppingCartList()) {
                shoppingCartListShoppingCartToAttach = em.getReference(shoppingCartListShoppingCartToAttach.getClass(), shoppingCartListShoppingCartToAttach.getCartId());
                attachedShoppingCartList.add(shoppingCartListShoppingCartToAttach);
            }
            client.setShoppingCartList(attachedShoppingCartList);
            em.persist(client);
            if (roleId != null) {
                roleId.getClientList().add(client);
                roleId = em.merge(roleId);
            }
            for (ShoppingCart shoppingCartListShoppingCart : client.getShoppingCartList()) {
                Client oldClientIdOfShoppingCartListShoppingCart = shoppingCartListShoppingCart.getClientId();
                shoppingCartListShoppingCart.setClientId(client);
                shoppingCartListShoppingCart = em.merge(shoppingCartListShoppingCart);
                if (oldClientIdOfShoppingCartListShoppingCart != null) {
                    oldClientIdOfShoppingCartListShoppingCart.getShoppingCartList().remove(shoppingCartListShoppingCart);
                    oldClientIdOfShoppingCartListShoppingCart = em.merge(oldClientIdOfShoppingCartListShoppingCart);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Client client) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client persistentClient = em.find(Client.class, client.getClientId());
            Role roleIdOld = persistentClient.getRoleId();
            Role roleIdNew = client.getRoleId();
            List<ShoppingCart> shoppingCartListOld = persistentClient.getShoppingCartList();
            List<ShoppingCart> shoppingCartListNew = client.getShoppingCartList();
            if (roleIdNew != null) {
                roleIdNew = em.getReference(roleIdNew.getClass(), roleIdNew.getRoleId());
                client.setRoleId(roleIdNew);
            }
            List<ShoppingCart> attachedShoppingCartListNew = new ArrayList<ShoppingCart>();
            for (ShoppingCart shoppingCartListNewShoppingCartToAttach : shoppingCartListNew) {
                shoppingCartListNewShoppingCartToAttach = em.getReference(shoppingCartListNewShoppingCartToAttach.getClass(), shoppingCartListNewShoppingCartToAttach.getCartId());
                attachedShoppingCartListNew.add(shoppingCartListNewShoppingCartToAttach);
            }
            shoppingCartListNew = attachedShoppingCartListNew;
            client.setShoppingCartList(shoppingCartListNew);
            client = em.merge(client);
            if (roleIdOld != null && !roleIdOld.equals(roleIdNew)) {
                roleIdOld.getClientList().remove(client);
                roleIdOld = em.merge(roleIdOld);
            }
            if (roleIdNew != null && !roleIdNew.equals(roleIdOld)) {
                roleIdNew.getClientList().add(client);
                roleIdNew = em.merge(roleIdNew);
            }
            for (ShoppingCart shoppingCartListOldShoppingCart : shoppingCartListOld) {
                if (!shoppingCartListNew.contains(shoppingCartListOldShoppingCart)) {
                    shoppingCartListOldShoppingCart.setClientId(null);
                    shoppingCartListOldShoppingCart = em.merge(shoppingCartListOldShoppingCart);
                }
            }
            for (ShoppingCart shoppingCartListNewShoppingCart : shoppingCartListNew) {
                if (!shoppingCartListOld.contains(shoppingCartListNewShoppingCart)) {
                    Client oldClientIdOfShoppingCartListNewShoppingCart = shoppingCartListNewShoppingCart.getClientId();
                    shoppingCartListNewShoppingCart.setClientId(client);
                    shoppingCartListNewShoppingCart = em.merge(shoppingCartListNewShoppingCart);
                    if (oldClientIdOfShoppingCartListNewShoppingCart != null && !oldClientIdOfShoppingCartListNewShoppingCart.equals(client)) {
                        oldClientIdOfShoppingCartListNewShoppingCart.getShoppingCartList().remove(shoppingCartListNewShoppingCart);
                        oldClientIdOfShoppingCartListNewShoppingCart = em.merge(oldClientIdOfShoppingCartListNewShoppingCart);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = client.getClientId();
                if (findClient(id) == null) {
                    throw new NonexistentEntityException("The client with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client client;
            try {
                client = em.getReference(Client.class, id);
                client.getClientId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client with id " + id + " no longer exists.", enfe);
            }
            Role roleId = client.getRoleId();
            if (roleId != null) {
                roleId.getClientList().remove(client);
                roleId = em.merge(roleId);
            }
            List<ShoppingCart> shoppingCartList = client.getShoppingCartList();
            for (ShoppingCart shoppingCartListShoppingCart : shoppingCartList) {
                shoppingCartListShoppingCart.setClientId(null);
                shoppingCartListShoppingCart = em.merge(shoppingCartListShoppingCart);
            }
            em.remove(client);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Client> findClientEntities() {
        return findClientEntities(true, -1, -1);
    }

    public List<Client> findClientEntities(int maxResults, int firstResult) {
        return findClientEntities(false, maxResults, firstResult);
    }

    private List<Client> findClientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Client.class));
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

    public Client findClient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Client> rt = cq.from(Client.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

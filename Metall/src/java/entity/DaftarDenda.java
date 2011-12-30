/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rifanda Putri
 */
public class DaftarDenda implements Serializable {
 
    private EntityManagerFactory emf = null;
            

    public DaftarDenda() {
        emf = Persistence.createEntityManagerFactory("MetallPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Denda denda) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(denda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Denda denda;
            try {
                denda = em.getReference(Denda.class, id);
                denda.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The denda with id " + id + " no longer exists.", enfe);
            }
            em.remove(denda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Denda> findDendaEntities() {
        return findDendaEntities(true, -1, -1);
    }

    public List<Denda> findDendaEntities(int maxResults, int firstResult) {
        return findDendaEntities(false, maxResults, firstResult);
    }

    private List<Denda> findDendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Denda.class));
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

    public Denda findDenda(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Denda.class, id);
        } finally {
            em.close();
        }
    }

    public int getDendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Denda> rt = cq.from(Denda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

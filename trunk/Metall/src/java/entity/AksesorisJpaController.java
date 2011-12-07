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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author a
 */
public class AksesorisJpaController implements Serializable {

    public AksesorisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aksesoris aksesoris) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aksesoris);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aksesoris aksesoris) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aksesoris = em.merge(aksesoris);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = aksesoris.getId();
                if (findAksesoris(id) == null) {
                    throw new NonexistentEntityException("The aksesoris with id " + id + " no longer exists.");
                }
            }
            throw ex;
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
            Aksesoris aksesoris;
            try {
                aksesoris = em.getReference(Aksesoris.class, id);
                aksesoris.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aksesoris with id " + id + " no longer exists.", enfe);
            }
            em.remove(aksesoris);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aksesoris> findAksesorisEntities() {
        return findAksesorisEntities(true, -1, -1);
    }

    public List<Aksesoris> findAksesorisEntities(int maxResults, int firstResult) {
        return findAksesorisEntities(false, maxResults, firstResult);
    }

    private List<Aksesoris> findAksesorisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aksesoris.class));
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

    public Aksesoris findAksesoris(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aksesoris.class, id);
        } finally {
            em.close();
        }
    }

    public int getAksesorisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aksesoris> rt = cq.from(Aksesoris.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import javax.transaction.UserTransaction;

/**
 *
 * @author Aspire
 */
public class TambahSewaJpaController implements Serializable {

    public TambahSewaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TambahSewa tambahSewa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tambahSewa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TambahSewa tambahSewa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tambahSewa = em.merge(tambahSewa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tambahSewa.getId();
                if (findTambahSewa(id) == null) {
                    throw new NonexistentEntityException("The tambahSewa with id " + id + " no longer exists.");
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
            TambahSewa tambahSewa;
            try {
                tambahSewa = em.getReference(TambahSewa.class, id);
                tambahSewa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tambahSewa with id " + id + " no longer exists.", enfe);
            }
            em.remove(tambahSewa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TambahSewa> findTambahSewaEntities() {
        return findTambahSewaEntities(true, -1, -1);
    }

    public List<TambahSewa> findTambahSewaEntities(int maxResults, int firstResult) {
        return findTambahSewaEntities(false, maxResults, firstResult);
    }

    private List<TambahSewa> findTambahSewaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TambahSewa.class));
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

    public TambahSewa findTambahSewa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TambahSewa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTambahSewaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TambahSewa> rt = cq.from(TambahSewa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

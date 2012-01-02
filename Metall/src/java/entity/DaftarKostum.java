/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.util.ArrayList;
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
 * @author a
 */
public class DaftarKostum {

    public DaftarKostum() {
         emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // getting new kostum
    public void addKostum(Kostum kostum) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kostum);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
      //getting list of Kostum
    public List<Kostum> getDaftarKostum() {
        List<Kostum> daftarKostum = new ArrayList<Kostum>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Kostum AS o");
            daftarKostum = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarKostum;
    }
    
    
  

    public void editKostum(Kostum kostum){
        EntityManager em = null;
        em.getTransaction().begin();
        try {
            em.merge(kostum);
            em.getTransaction().commit();
        } catch (Exception ex) {
             em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteKostum(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
             Kostum kostum;
            try {
                kostum = em.find(Kostum.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kostum with id " + id + " no longer exists.", enfe);
            }
            em.remove(kostum);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Kostum> findKostumEntities() {
        return findKostumEntities(true, -1, -1);
    }

    public List<Kostum> findKostumEntities(int maxResults, int firstResult) {
        return findKostumEntities(false, maxResults, firstResult);
    }

    private List<Kostum> findKostumEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Kostum.class));
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

    public Kostum findKostum(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kostum.class, id);
        } finally {
            em.close();
        }
    }

    public int getKostumCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Kostum> rt = cq.from(Kostum.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }


    public boolean checkKostum(String nama_kostum) {
       
         boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Kostum AS o WHERE o.nama_kostum=:nama_kostum");
            q.setParameter("nama_kostum", nama_kostum);
            int jumlah_kostum = ((Long) q.getSingleResult()).intValue();
            if (jumlah_kostum > 0) {
                result = true;
            }
             } finally {
            em.close();
        }
        return result;
    }
    
  public boolean cekKostum() { 
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Kostum AS o");
            int jumlahKostum = ((Long) q.getSingleResult()).intValue();
            if (jumlahKostum > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
  }}

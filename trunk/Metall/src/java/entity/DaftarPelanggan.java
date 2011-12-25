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
 * @author Denia
 */
public class DaftarPelanggan implements Serializable {
 
    private EntityManagerFactory emf = null;
            

    public DaftarPelanggan() {
        emf = Persistence.createEntityManagerFactory("MetallPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pelanggan pelanggan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pelanggan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    //Menambahkan method check untuk melihat adanya pengguna atau tidak
    public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM User AS o WHERE o.username=:usr AND o.password=:pswd");
            q.setParameter("username", username);
            q.setParameter("password", password);
            int jumlahPelanggan = ((Long) q.getSingleResult()).intValue();
            if (jumlahPelanggan > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    
    //Menambahkan method getPelanggan yang dipanggil dari servlet Login
    public Pelanggan getPelanggan(String username, String password) {
        Pelanggan pelanggan = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.username=:usr AND o.password=:pswd");
                q.setParameter("username", username);
                q.setParameter("password", password);
                pelanggan = (Pelanggan) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pelanggan;
    }
    
    
    
    
    
    
    
    public void edit(Pelanggan pelanggan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pelanggan = em.merge(pelanggan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pelanggan.getId();
                if (findPelanggan(id) == null) {
                    throw new NonexistentEntityException("The pelanggan with id " + id + " no longer exists.");
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
            Pelanggan pelanggan;
            try {
                pelanggan = em.getReference(Pelanggan.class, id);
                pelanggan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pelanggan with id " + id + " no longer exists.", enfe);
            }
            em.remove(pelanggan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pelanggan> findPelangganEntities() {
        return findPelangganEntities(true, -1, -1);
    }

    public List<Pelanggan> findPelangganEntities(int maxResults, int firstResult) {
        return findPelangganEntities(false, maxResults, firstResult);
    }

    private List<Pelanggan> findPelangganEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pelanggan.class));
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

    public Pelanggan findPelanggan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pelanggan.class, id);
        } finally {
            em.close();
        }
    }

    public int getPelangganCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pelanggan> rt = cq.from(Pelanggan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
//Dibawah ini menambahkan method getPelanggan yang dipanggil dari servlet Login
    /*public Pelanggan getPelanggan(String username, String password) {
        throw new UnsupportedOperationException("Not yet implemented"); 
    }*/
    
}

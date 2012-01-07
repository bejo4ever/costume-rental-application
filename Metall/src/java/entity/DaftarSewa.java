/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Rifanda Putri
 */
public class DaftarSewa implements Serializable {

    public DaftarSewa() {
         emf = Persistence.createEntityManagerFactory("MetallPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public boolean checkSewa(String username, Long id_sewa ) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Sewa AS o WHERE o.username=:username AND o.id_sewa=:id_sewa");
            q.setParameter("username", username);
            q.setParameter("id_sewa", id_sewa);
            int jumlahSewa = ((Long) q.getSingleResult()).intValue();
            if (jumlahSewa > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public boolean cekSewa () {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Sewa AS o");
            int jumlahSewa = ((Long) q.getSingleResult()).intValue();
            if (jumlahSewa > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public void addSewa(Sewa sewa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sewa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }}
    
     // method untuk menampilkan list/daftar sewa dari username
    public List<Sewa> getDaftarSewa() {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o");
            daftarSewa = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarSewa;
    }
    
      public List<Sewa> getDaftarSewa(Pelanggan username) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o");
            daftarSewa = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarSewa;
    }
    
//method untuk mengfungsikan tombol edit
   public void editSewa(Sewa sewa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(sewa);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
   
   //method untuk mengfungsikan tombol hapus
   public void deleteSewa(Sewa username) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Sewa Sewa;
            try {
                Sewa = em.find(Sewa.class, username);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The Sewa with id " + username + " no longer exists.", enfe);
            }
            em.remove(Sewa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
   
        }
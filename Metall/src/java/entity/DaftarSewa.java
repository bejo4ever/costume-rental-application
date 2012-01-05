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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author a
 */
public class DaftarSewa implements Serializable {

    public DaftarSewa() {
         emf = Persistence.createEntityManagerFactory("MetallPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
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

   public void editSewa(Sewa sewa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(sewa);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void destroy(Long id_sewa) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sewa sewa;
            try {
                sewa = em.getReference(Sewa.class, id_sewa);
                sewa.getId_sewa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sewa with id_sewa " + id_sewa + " no longer exists.", enfe);
            }
            em.remove(sewa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    // method untuk menampilkan list/daftar sewa dari tabel sewa
     
    public List<Sewa> getDaftarSewa() {
        List<Sewa> daftar_sewa = new ArrayList<Sewa>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM sewa AS o");
            daftar_sewa = q.getResultList();
        } finally {
            em.close();
        }
        return daftar_sewa;
    }

    //method untuk mengambil data satu pengguna pada tabel User
     //berdasarkan parameter username   
}
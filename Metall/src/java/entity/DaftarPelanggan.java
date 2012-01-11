/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

/**
 *
 * @author Denia
 */
public class DaftarPelanggan {

    public DaftarPelanggan() {
        emf = Persistence.createEntityManagerFactory("MetallPU");
    }
    private EntityManagerFactory emf = null;
 
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      /**
     * @param username String
     * @param password String
     *
     * method yang digunakan untuk mengecek keberadaan pengguna
     * pada tabel Pelanggan berdasarkan parameter username dan password
     */
    
     public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Pelanggan AS o WHERE o.username=:usr AND o.password=:pass");
            q.setParameter("usr", username);
            q.setParameter("pass", password);
            int jumlahPelanggan = ((Long) q.getSingleResult()).intValue();
            if (jumlahPelanggan > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
     } 
         /**
     * @param username String
     *
     * method yang digunakan untuk mengecek ketersediaan pelanggan
     */
    public boolean checkPelanggan(String username) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Pelanggan AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            int jumlahPelanggan = ((Long) q.getSingleResult()).intValue();
            if (jumlahPelanggan > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
        /**
     * @param username String
     * @param password String
     * @return User entity
     *
     * method untuk mengambil data satu pelanggan pada tabel User
     * berdasarkan parameter username dan password
     */
    public Pelanggan getPelanggan(String username, String password) {
        Pelanggan pelanggan = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o WHERE o.username=:usr AND o.password=:pswd");
                q.setParameter("usr", username);
                q.setParameter("pswd", password);
                pelanggan = (Pelanggan) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pelanggan;
    }
    
    /**
     * @param username String
     * @return Pelanggan entity
     *
     * method untuk mengambil data satu pelanggan pada tabel Pelanggan
     * berdasarkan parameter username
     */
    public Pelanggan getPelangganFromName(String username) {
        Pelanggan pelanggan = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkPelanggan(username);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o WHERE o.username=:usr");
                q.setParameter("usr", username);
                pelanggan = (Pelanggan) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pelanggan;
    }
    
    public Pelanggan getPelangganFromId(long id) {
        Pelanggan pelanggan = null;
        EntityManager em = getEntityManager();
        try {

                Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o WHERE o.id=:id");
                q.setParameter("id", id);
                pelanggan = (Pelanggan) q.getSingleResult();

        } finally {
            em.close();
        }
        return pelanggan;
    }
    
     /**
     * @param user Pelanggan entity
     *
     * method untuk mengubah data pelanggan
     * yang sudah ada pada daftar pelanggan
     */
     public void editPelanggan(Pelanggan pelanggan) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(pelanggan);
            em.getTransaction().commit();
        } catch (Exception e){//jk eerror
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
/**
     * @param user Pelanggan entity
     *
     * method untuk menambahkan data pengguna baru ke dalam tabel pelanggan
     */
    public void addPelanggan(Pelanggan pelanggan) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pelanggan);
            em.getTransaction().commit();
        } catch (Exception e) {
        em.getTransaction().rollback();        } 
        finally {
            em.close();
        }}

    /**
     * @return List<Pelanggan>
     *
     * method untuk menampilkan list/daftar pelanggan dari tabel Pelanggan
     */
    public List<Pelanggan> getPlgn() {
        List<Pelanggan> plgn = new ArrayList<Pelanggan>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o");
            plgn = q.getResultList();

        } finally {
            em.close();
        }
        return plgn;
    }
   /**
     * @param pelanggan String
     * @return List<Pelanggan>
     *
     * method untuk menampilkan list/daftar username pengguna dari tabel Pelanggan
     */
    public List<Pelanggan> getUsername(String username) {
        List<Pelanggan> plgn = new ArrayList<Pelanggan>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            plgn = q.getResultList();

        } finally {
            em.close();
        }
        return plgn;
    }

    public void deletePelanggan(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Pelanggan pelanggan;
            try {
               pelanggan = em.find(Pelanggan.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pelanggan with id " + id + " no longer exists.", enfe);
            }
            em.remove(pelanggan);
            em.getTransaction().commit();
        } 
        catch (Exception e) {
            em.getTransaction().rollback();
        } 
        finally {
            if (em != null) {
                em.close();
            }
        }
    }}

    /**
     * @return List<Pelanggan>
     *
     * method untuk menampilkan list/daftar pengguna yang belum
     * dikonfirmasi dari tabel Pelanggan
     */
//    public List<Pelanggan> getUnconfirmedPlgn() {
//        List<Pelanggan> plgn = new ArrayList<Pelanggan>();
//        int stat = 0;
//        EntityManager em = getEntityManager();
//        try {
//            Query q = em.createQuery("SELECT object(o) FROM Pelanggan AS o WHERE o.status=:stat");
//            q.setParameter("status", stat);
//            List plgn1 = q.getResultList();
//
//        } finally {
//            em.close();
//        }
//        return plgn;
//    }}

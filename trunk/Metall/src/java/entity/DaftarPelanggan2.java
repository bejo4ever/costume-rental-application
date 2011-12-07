/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author a
 */
public class DaftarPelanggan2 {
//private int jumlahpelanggan = -1;
//    
//    public DaftarPelanggan2() {
//        emf = Persistence.createEntityManagerFactory("MetallPU");
//    }
//    private EntityManagerFactory emf = null;
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//     public int getJumlahPelanggan() {
//
//        if (jumlahpelanggan == -1) {
//            EntityManager em = null;
//            try {
//                em = getEntityManager();
//                Query q = em.createQuery("SELECT count(o) FROM pelanggan as o");
//                Number jumlah = (Number) q.getSingleResult();
//                jumlahpelanggan = jumlah.intValue();
//
//            } catch (javax.persistence.EntityNotFoundException e) {
//            } finally {
//                if (em != null) {
//                    em.close();
//                }
//            }
//        }
//
//        return jumlahpelanggan;
//    }
//    public List<Pelanggan> seluruhDaftarPelanggan () {
//        List<Pelanggan> pelanggan = null;
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            Query q = em.createQuery("SELECT object(o) FROM pelanggan as o ORDER BY o.id DESC");
//            q.setMaxResults(10);
//            pelanggan = q.getResultList();
//
//        } catch (javax.persistence.EntityNotFoundException e) {
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//        return pelanggan;
//    }
//    
//    public void tambahPelang(Pelanggan pelanggan) {
//         EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            pelanggan.setKodepelanggan(null);
//            pelanggan.setUsername(null);
//            pelanggan.setPassword(null);
//            pelanggan.setNama_pelanggan(null);
//            pelanggan.setAlamat_pelanggan(null);
//            pelanggan.setTelpon_pelanggan(null);
//            em.persist(pelanggan);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//
//    }
   
}

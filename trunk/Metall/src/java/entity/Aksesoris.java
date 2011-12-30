/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author a
 */
@Entity
public class Aksesoris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kode_kostum;
    private String nama_aksesoris;
    private int harga_aksesoris;
    private String jumlah_aksesoris;
    private String deskripsi_aksesoris;
    
     public int getHarga_aksesoris() {
        return harga_aksesoris;
    }

    public void setHarga_aksesoris(int harga_aksesoris) {
        this.harga_aksesoris = harga_aksesoris;
    }
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getKode_kostum() {
        return kode_kostum;
    }
    
    public void setKode_kostum(String kode_kostum) {
        this.kode_kostum = kode_kostum;
    }
    
    public String getNama_aksesoris() {
        return nama_aksesoris;
    }
    
    public void setNama_aksesoris(String nama_aksesoris) {
        this.nama_aksesoris = nama_aksesoris;
    }
    
    public String getJumlah_aksesoris() {
        return jumlah_aksesoris;
    }
    public void setJumlah_aksesoris(String jumlah_aksesoris) {
        this.jumlah_aksesoris = jumlah_aksesoris;
    }
   
    public String getDeskripsi_aksesoris() {
        return deskripsi_aksesoris;
    }
    public void setDeskripsi_aksesoris(String deskripsi_aksesoris) {
        this.deskripsi_aksesoris = deskripsi_aksesoris;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aksesoris)) {
            return false;
        }
        Aksesoris other = (Aksesoris) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aksesoris[ id=" + id + " ]";
    }
    
}

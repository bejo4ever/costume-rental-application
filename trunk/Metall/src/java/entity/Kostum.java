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
public class Kostum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kode_kostum;
    private String nama_kostum;
    private String jumlah_kostum;
    private int harga_kostum;
    private String kategori_kostum;
    private String deskripsi_kostum;
    
    
    public int getHarga_kostum(){
        return harga_kostum;
    }
    public void setHarga_kostum(int harga_kostum) {
        this.harga_kostum = harga_kostum;
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
    
     public String getNama_kostum() {
        return nama_kostum;
    }
    public void setNama_kostum(String nama_kostum) {
        this.nama_kostum = nama_kostum;
    }
    
    public String getJumlah_kostum() {
        return jumlah_kostum;
    }
    public void setJumlah_kostum(String jumlah_kostum) {
        this.jumlah_kostum = jumlah_kostum;
    }
    
     public String getKategori_kostum() {
        return jumlah_kostum;
    }
    public void setKategori_kostum(String jumlah_kostum) {
        this.jumlah_kostum = jumlah_kostum;
    }
   
    public String getDeskripsi_kostum() {
        return deskripsi_kostum;
    }
    public void setDeskripsi_kostum(String deskripsi_kostum) {
        this.deskripsi_kostum = deskripsi_kostum;
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
        if (!(object instanceof Kostum)) {
            return false;
        }
        Kostum other = (Kostum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Kostum[ id=" + id + " ]";
    }
    
}

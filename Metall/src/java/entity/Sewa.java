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
public class Sewa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String kode_barang;
    private String tanggal_sewa;
    private String tanggal_kembali;
    private int total_harga_barang;
   
    
   public int getTotal_Harga_barang(){
        return total_harga_barang;
    }
    public void setTotal_Harga_barang(int total_harga_barang) {
        this.total_harga_barang = total_harga_barang;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
     public String getKode_barang() {
        return kode_barang;
    }
    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }
    public String getTanggal_sewa() {
        return tanggal_sewa;
    }
    public void setTanggal_sewa(String tanggal_sewa) {
        this.tanggal_sewa = tanggal_sewa;
    }
    public String getTanggal_kembali() {
        return tanggal_kembali;
    }
    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
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
        if (!(object instanceof Sewa)) {
            return false;
        }
        Sewa other = (Sewa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sewa[ id=" + id + " ]";
    }
    
}

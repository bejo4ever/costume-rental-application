/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author a
 */
@Entity
public class Sewa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_kostum;
    private Long id;
    private Long id_sewa;
    private String username;
    private String kode_barang;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sewa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date kembali;
    private int total_harga;
    private int denda;
   
    
   public int getTotal_Harga(){
        return total_harga;
    }
    public void setTotal_Harga(int total_harga) {
        this.total_harga = total_harga;
    }
    public Long getId_kostum() {
        return id_kostum;
    }
    public void setId_kostum(Long id_kostum) {
        this.id_kostum = id_kostum;
    }
    public Long getId_sewa() {
        return id_sewa;
    }
    public void setId_sewa(Long id_sewa) {
        this.id_sewa = id_sewa;
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
    public Date getSewa() {
        return sewa;
    }
    public void setSewa(Date sewa) {
        this.sewa = sewa;
    }
    public Date getKembali() {
        return kembali;
    }
    public void setKembali(Date kembali) {
        this.kembali = kembali;
    }
     public int getDenda(){
        return denda;
    }
    public void setDenda(int denda) {
        this.denda = denda;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_sewa != null ? id_sewa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sewa)) {
            return false;
        }
        Sewa other = (Sewa) object;
        if ((this.id_sewa == null && other.id_sewa != null) || (this.id_sewa != null && !this.id_sewa.equals(other.id_sewa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sewa[ id_sewa=" + id_sewa + " ]";
    }
    
}

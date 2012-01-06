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
 * @author Deela_abeezzS=
 */
@Entity
public class Pelanggan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String nama_pelanggan;
    private String alamat_pelanggan;
    private String telpon_pelanggan;
    private int tipe;
    //private int status;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getStatus(){
//        return status;
//    }
//    
//    public void setStatus(int status){
//        this.status = status;
//    }
    
    public String getTelpon_pelanggan(){
        return telpon_pelanggan;
    }
    public void setTelpon_pelanggan(String telpon_pelanggan) {
        this.telpon_pelanggan = telpon_pelanggan;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    
    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }
    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }
     public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
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
        if (!(object instanceof Pelanggan)) {
            return false;
        }
        Pelanggan other = (Pelanggan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pelanggan[ id=" + id + " ]";
    }

    //Dibawah ini menambahkan method getTipe yang dipanggil dari servlet Login
   // public int getTipe() {
     //   throw new UnsupportedOperationException("Not yet implemented");
  //  }
    
}

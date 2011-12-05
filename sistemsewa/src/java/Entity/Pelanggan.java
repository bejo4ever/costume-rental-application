/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Rifanda Putri
 */
public class Pelanggan {
    
    @Entity
@Table(name = "pelanggan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelanggan.findAll", query = "SELECT w FROM Pelanggan w"),
    @NamedQuery(name = "Pelanggan.findByNama", query = "SELECT w FROM Pelanggan w WHERE w.nama = :nama"),
    @NamedQuery(name = "Pelanggan.findByUsername", query = "SELECT w FROM Pelanggan w WHERE w.username = :username"),
    @NamedQuery(name = "Pelanggan.findByPassword", query = "SELECT w FROM Pelanggan w WHERE w.password = :password"),
    @NamedQuery(name = "Pelanggan.findByJenisKelamin", query = "SELECT w FROM Pelanggan w WHERE w.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Pelanggan.findByAlamat", query = "SELECT w FROM Pelanggan w WHERE w.alamat = :alamat"),
    @NamedQuery(name = "Pelanggan.findByTelepon", query = "SELECT w FROM Pelanggan w WHERE w.telepon = :telepon"),
    @NamedQuery(name = "Pelanggan.findByUmur", query = "SELECT w FROM Pelanggan w WHERE w.umur = :umur"),
    @NamedQuery(name = "Pelanggan.findByFoto", query = "SELECT w FROM Pelanggan w WHERE w.foto = :foto"),
    
public class Pelanggan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private int username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 4, max = 9)
    @Column(name = "jenisKelamin")
    private String jenisKelamin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "telepon")
    private int telepon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "umur")
    private int umur;
    @Column(name = "foto")
    private String foto;

    public Pelanggan() {
    }

    public Pelanggan(int username) {
        this.username = username;
    }

    public Warga(String nama, int username, String password, String jenisKelamin, String alamat, int telepon, int umur, String foto) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.umur = umur;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getTelepon() {
        return telepon;
    }

    public void setTelepon(int telepon) {
        this.telepon = telepon;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Pelanggan)) {
            return false;
        }
        Pelanggan other = (Pelanggan) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pelanggan[ username=" + username + " ]";
    }

}
    }

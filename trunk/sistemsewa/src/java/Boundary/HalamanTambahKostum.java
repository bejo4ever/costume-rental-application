/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;
import entity.DaftarKostum;
import entity.Kostum;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PUTRITOP
 */
public class HalamanTambahKostum extends Boundary {

    @Override
    protected void process() {
         setMessage("");
         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_kodekostum()) {
                    if (validate_namakostum()) {
                        if (validate_jumlahkostum()) {
                            if(validate_hargakostum()) {
                                if(validate_kategorikostum()) {
                                    if(validate_deskripsikostum()) {
                                    DaftarKostum dk = new DaftarKostum();
                                    Kostum kostum = new Kostum();
                                    String kostumHtml = getRequest().getParameter("kostum");
                                    String kodeKostumHtml = getRequest().getParameter("kodekostum");
                                    String namaKostumHtml = getRequest().getParameter("namakostum");
                                    String jumlahKostumHtml = getRequest().getParameter("jumlahkostum");
                                    String hargaKostumHtml = getRequest().getParameter("hargakostum");
                                    String kategoriKostumHtml = getRequest().getParameter("kategorikostum");
                                    String deskripsiKostumHtml = getRequest().getParameter("deskripsikostum");
                                    kostum.setKodekostum(kodeKostumHtml);
                                    kostum.setNamakostum(namaKostumHtml);
                                    kostum.setJumlahkostum(jumlahKostumHtml);
                                    kostum.setHargakostum(hargaKostumHtml);
                                    kostum.setKategoritkostum(kategoriKostumHtml);
                                    kostum.setDeskripsikostum(deskripsiKostumHtml);
                                    dk.tambahKost(kostum);
                                    }
                                  }
                                }
                              }
                            }
                        }
                getResponse().sendRedirect("daftar_pesan");
                   } catch (IOException ex) {
                Logger.getLogger(HalamanTambahKostum.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahkostumnya
                   }
                 }
               }
    public boolean validate_kodekostum() {
        
        String kodekostum = getRequest().getParameter("kodekostum");
        if(kodekostum == null){
            return false;
        }
        if(kodekostum.trim().equals("")){
            return false;
        }
          return true;
    }
    public boolean validate_namakostum() {
        
        String namakostum = getRequest().getParameter("namakostum");
        if(namakostum == null){
            return false;
        }
        if(namakostum.trim().equals("")){
            return false;
        }
          return true;
    }
    public boolean validate_jumlahkostum() {
        
        String jumlahkostum = getRequest().getParameter("jumlahkostum");
        if(jumlahkostum == null){
            return false;
        }
        if(jumlahkostum.trim().equals("")){
            return false;
        }
          return true;
    }
    private boolean validate_hargakostum() {
        String hargakostum = getRequest().getParameter("hargakostum");
        if(hargakostum == null){
            return false;
        }
        if(hargakostum.trim().equals("")){
            return false;
        }
          return true;
    }
    private boolean validate_kategorikostum() {
       String kategorikostum = getRequest().getParameter("kategorikostum");
        if(kategorikostum == null){
            return false;
        }
        if(kategorikostum.trim().equals("")){
            return false;
        }
          return true;
    }
    private boolean validate_deskripsikostum() {
         String deskripsikostum = getRequest().getParameter("deskripsikostum");
        if(deskripsikostum == null){
            return false;
        }
        if(deskripsikostum.trim().equals("")){
            return false;
        }
          return true;
    }

}

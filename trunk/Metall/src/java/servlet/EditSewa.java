/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarSewa;
import entity.Sewa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rifanda Putri
 */
@WebServlet(name = "EditSewa", urlPatterns = {"/EditSewa"})
public class EditSewa extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String message = null;
        Long id_sewa = Long.parseLong(request.getParameter("id_sewa"));
        String usernamee = request.getParameter("username");
        String kodee_kostum = request.getParameter("kode_kostum");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tgll_sewa = request.getParameter("tgl_sewa");
        String blnn_sewa = request.getParameter("bln_sewa");
        String thnn_sewa = request.getParameter("thn_sewa");
        String tgll_kembali = request.getParameter("tgl_kembali");
        String blnn_kembali = request.getParameter("bln_kembali");
        String thnn_kembali = request.getParameter("thn_kembali");
        String hargaa_total = request.getParameter("harga_total");
        String denda = request.getParameter("denda");
        String sewaa = thnn_sewa + "-" + blnn_sewa + "-" + tgll_sewa;
        String kembali = thnn_kembali + "-" + blnn_kembali + "-" + tgll_kembali;
        Date tgl_sewa = dateFormat.parse(sewaa);
        Date tgl_kembali = dateFormat.parse(kembali);
        int status = 0;

        Sewa s = new Sewa();
        //RequestDispatcher page = null;
        DaftarSewa ds = new DaftarSewa();
        s = ds.getSewa(id_sewa);

        try {
            //first if --> Jika ada field bertanda bintang yang kosong (tidak diisi)
            if (tgll_sewa.equals("") || blnn_sewa.equals("") || thnn_sewa.equals("")
                    || tgll_kembali.equals("") || blnn_kembali.equals("") || thnn_kembali.equals("")||hargaa_total.equals("")) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua kolom dengan tanda * ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            }//end of first if
            else {
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();

                c1.set(Integer.parseInt(thnn_sewa), Integer.parseInt(blnn_sewa), Integer.parseInt(tgll_sewa));
                c2.set(Integer.parseInt(thnn_kembali), Integer.parseInt(blnn_kembali), Integer.parseInt(tgll_kembali));

                //Membandingkan 2 inputan pada Field waktu mulai penyewaan dengan waktu akhir penyewaan
                if (c2.before(c1)) {
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message = "Waktu akhir penyewaan harus setelah waktu awal penyewaan";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                }//end of if
                else {
                    //adding sewa to database Sewa
                    s.setUsername(usernamee);
                    s.setKode_kostum(kodee_kostum);
                    s.setSewa(tgl_sewa);
                    s.setKembali(tgl_kembali);
                    //kurang mengisi harga total
                   // int Harga_total= kode_kostum;
                    s.setHarga_total(hargaa_total);
                    
                    //calculate price amount
                    long milliseconds1 = c1.getTimeInMillis();
                    long milliseconds2 = c2.getTimeInMillis();
                    long diff = milliseconds2 - milliseconds1;
                    int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                    int Denda = 5000 * diffDays;
                    s.setDenda(Denda);
                    
                ds.editSewa(s);
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("DaftarSewa.jsp");
                    message = "Data Sewa Berhasil diubah";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                }

            }//end of first else
        }//end of try
        catch (Exception e) {
        }
            }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        DaftarSewa ds = new DaftarSewa();
        Sewa s = new Sewa();

        Long id_sewa = Long.parseLong(request.getParameter("id_sewa"));
        s = (Sewa) ds.getSewa(id_sewa);
        request.setAttribute("sewa", s);
        dis = request.getRequestDispatcher("xxxx.jsp");
        dis.include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EditSewa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
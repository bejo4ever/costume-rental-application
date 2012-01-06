/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarPelanggan;
import entity.Pelanggan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a
 */
//@WebServlet(name = "EditPelanggan", urlPatterns = {"/editpelanggan"})
public class EditPelanggan extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nama_pelanggan = request.getParameter("nama_pelanggan");
        String alamat_pelanggan = request.getParameter("alamat_pelanggan");
        String telpon_pelanggan = request.getParameter("telpon_pelanggan");
        
        Pelanggan pelanggan = new Pelanggan();
        DaftarPelanggan dp = new DaftarPelanggan();
        pelanggan = dp.getPelangganFromName(username);

        pelanggan.setUsername(username);
        pelanggan.setPassword(password);
        pelanggan.setNama_pelanggan(nama_pelanggan);
        pelanggan.setAlamat_pelanggan(alamat_pelanggan);
        pelanggan.setTelpon_pelanggan(telpon_pelanggan);
        request.setAttribute("pengguna", pelanggan);
        
        try {
        if (nama_pelanggan.equals("") || alamat_pelanggan.equals("") || telpon_pelanggan.equals("")
                   || username.equals("") || password.equals("")) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } else {
                if (pelanggan.getPassword() != password) {
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message = "Password Salah";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                } else {
                    dp.editPelanggan(pelanggan);
                    List<Pelanggan> plgn = dp.getPlgn();
                    request.setAttribute("pengguna", plgn);
                    //diarahkan ke halaman profil penyewa tempat
                     RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/SuccessUpdating.jsp");
                message = "Data Pengguna berhasil diubah";
                String page = "DaftarPengguna";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
                }
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
//        finally {            
//            out.close();
//        }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        DaftarPelanggan dp = new DaftarPelanggan();
        Pelanggan p = new Pelanggan();

        //mengambil parameter yang sudah dikirim dari halaman daftarPengguna.jsp
        String username = request.getParameter("username");
        p = dp.getPelangganFromName(username);
        request.setAttribute("pengguna", p);
        dis = request.getRequestDispatcher("EditPelanggan.jsp");
        dis.include(request, response);
}/** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
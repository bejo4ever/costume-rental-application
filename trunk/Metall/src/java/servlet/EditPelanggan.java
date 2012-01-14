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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String message = null;
        int tipe = Integer.parseInt(request.getParameter("tipe"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nama_pelanggan = request.getParameter("nama_pelanggan");
        String alamat_pelanggan = request.getParameter("alamat_pelanggan");
        String telpon_pelanggan = request.getParameter("telpon_pelanggan");
        
        Pelanggan pelanggan = new Pelanggan();
        RequestDispatcher page = null;
        DaftarPelanggan dp = new DaftarPelanggan();
        HttpSession session = request.getSession();
        pelanggan = dp.getPelangganFromName(username);

        try {
        if (username.equals("") || password.equals("") || nama_pelanggan.equals("") 
                   || alamat_pelanggan.equals("") || telpon_pelanggan.equals("") ) {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_page.jsp");
                message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
            } else  if (pelanggan.getUsername().equals(username) != pelanggan.getPassword().equals(password)) {
                    RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message = "Password Salah";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                } else {
                      pelanggan = dp.getPelangganFromName(username);
                        pelanggan.setUsername(username);
                        pelanggan.setPassword(password);
                        pelanggan.setNama_pelanggan(nama_pelanggan);
                        pelanggan.setAlamat_pelanggan(alamat_pelanggan);
                        pelanggan.setTelpon_pelanggan(telpon_pelanggan);
                        dp.editPelanggan(pelanggan);
        
        
                    page = request.getRequestDispatcher("/dftrplg");
            page.forward(request, response);
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

        if (session.getAttribute("sessionusername") != null) {
            String username = (String) session.getAttribute("sessionusername");

            boolean hasilCheck = dp.checkPelanggan(username);
            if (hasilCheck) {
                //mengambil user berdasarkan username dari Daftar User
                p = dp.getPelangganFromName(username);
                if (p.getTipe() == 1) {
                    request.setAttribute("pelanggan", p);
                    dis = request.getRequestDispatcher("/editPelanggan.jsp");
                    dis.include(request, response);
                } else {
                    dis = request.getRequestDispatcher("listpelanggan2");
                    dis.forward(request, response);
                }}}
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Pelanggan;
import entity.DaftarPelanggan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
@WebServlet(name = "TambahPelanggan", urlPatterns = {"/tambahpelanggan"})
public class TambahPelanggan extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nama_pelanggan = request.getParameter("nama_pelanggan");
            String alamat_pelanggan = request.getParameter("alamat_pelanggan");
            int telepon_pelanggan = Integer.parseInt(request.getParameter("telepon_kostum"));
            Pelanggan user = new Pelanggan();
            DaftarPelanggan dp = new DaftarPelanggan();
            user.setUsername(username);
            user.setPassword(password);
            user.setNama_pelanggan(nama_pelanggan);
            user.setAlamat_pelanggan(alamat_pelanggan);
            user.setTelpon_pelanggan(telepon_pelanggan);
            dp.create(user);
            
        } finally {            
            out.close();
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
        processRequest(request, response);
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

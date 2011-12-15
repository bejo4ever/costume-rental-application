/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarSewa;
import entity.Sewa;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TambahSewa", urlPatterns = {"/TambahSewa"})
public class TambahSewa extends HttpServlet {
    
    public String addCostume(HttpServletRequest request) {

        String username = request.getParameter("username");
        String kode_barang = request.getParameter("kode_barang");
        String tanggal_sewa = request.getParameter("tanggal_sewa");
        String tanggal_kembali = request.getParameter("tanggal_kembali");
        int total_harga_barang = Integer.parseInt(request.getParameter("total_harga_barang"));
        Sewa sewa = new Sewa();
        DaftarSewa dk = new DaftarSewa();
        sewa.setUsername(username);
        sewa.setKode_barang(kode_barang);
        sewa.setTanggal_sewa(tanggal_sewa);
        sewa.setTanggal_kembali(tanggal_kembali);
        sewa.setTotal_Harga_barang(total_harga_barang);

        dk.create(sewa);

        return "daftarsewainfo.jsp";
    }

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
        RequestDispatcher dis = null;

        dis = request.getRequestDispatcher(this.addCostume(request));
        dis.forward(request, response);

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

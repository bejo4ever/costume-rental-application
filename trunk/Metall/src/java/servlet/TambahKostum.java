/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarKostum;
import entity.Kostum;
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
 * @author a
 */
@WebServlet(name = "TambahKostum", urlPatterns = {"/kostum"})
public class TambahKostum extends HttpServlet {

    public String addCostume(HttpServletRequest request) {

        String kode_kostum = request.getParameter("kode_kostum");
        String nama_kostum = request.getParameter("nama_kostum");
        String jumlah_kostum = request.getParameter("jumlah_kostum");
        int harga_kostum = Integer.parseInt(request.getParameter("harga_kostum"));
        String kategori_kostum = request.getParameter("kategori_kostum");
        String deskripsi_kostum = request.getParameter("deskripsi_kostum");
        Kostum kostum = new Kostum();
        DaftarKostum dk = new DaftarKostum();
        kostum.setKode_kostum(kode_kostum);
        kostum.setNama_kostum(nama_kostum);
        kostum.setJumlah_kostum(jumlah_kostum);
        kostum.setHarga_kostum(harga_kostum);
        kostum.setKategori_kostum(kategori_kostum);
        kostum.setDeskripsi_kostum(deskripsi_kostum);

        dk.create(kostum);

        return "daftarkostuminfo.jsp";
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

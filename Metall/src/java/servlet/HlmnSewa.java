/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rifanda Putri
 */
@WebServlet(name = "HlmnSewa", urlPatterns = {"/HlmnSewa"})
public class HlmnSewa extends HttpServlet {

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
            RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("DaftarSewa") != null) {
            if (session.getAttribute("DaftarSewa").equals("HalamanSewa")) {
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
            dis = request.getRequestDispatcher("/daftarsewa.jsp");
            dis.forward(request, response);
            }
        } else {
            dis = request.getRequestDispatcher("/sewaerror.jsp");
            dis.include(request, response);            
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(HlmnSewa.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(HlmnSewa.class.getName()).log(Level.SEVERE, null, ex);
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

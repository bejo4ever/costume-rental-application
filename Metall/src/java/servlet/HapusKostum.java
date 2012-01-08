/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarKostum;
import entity.Kostum;
import entity.Pelanggan;
import entity.DaftarPelanggan;
import entity.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aspire
 */

public class HapusKostum extends HttpServlet {

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
        String message;
        String page;
       // Long gedungid = Long.parseLong(request.getParameter("gedungid"));
        
        DaftarKostum dk = new DaftarKostum();
        Kostum kostum = new Kostum();
        HttpSession session = request.getSession();
       
        dk.deleteKostum(kostum);
        
        RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/view_sukses.jsp");
                message = "Data kostum berhasil dihapus";
                page = "ListKostum";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
            }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } 
        catch (NonexistentEntityException ex) {
            Logger.getLogger(HapusKostum.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } 
        catch (NonexistentEntityException ex) {
            Logger.getLogger(HapusKostum.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HapusKostum</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HapusKostum at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        @Override
    public String getServletInfo() {
        return "Short description";
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

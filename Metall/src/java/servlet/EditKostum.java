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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
public class EditKostum extends HttpServlet {

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
       
        String message = null;
        String kode_kostum = request.getParameter("kode_kostum");
        String nama_kostum = request.getParameter("nama_kostum");
        String jumlah_kostum = request.getParameter("jumlah_kostum");
        int harga_kostum = Integer.parseInt(request.getParameter("harga_kostum"));
        String kategori_kostum = request.getParameter("kategori_kostum");
        String deskripsi_kostum = request.getParameter("deskripsi_kostum");
        
        DaftarKostum dk = new DaftarKostum();
        Kostum kostum = new Kostum();
        
        kostum.setKode_kostum(kode_kostum);
        kostum.setNama_kostum(nama_kostum);
        kostum.setJumlah_kostum(jumlah_kostum);
        kostum.setHarga_kostum(harga_kostum);
        kostum.setKategori_kostum(kategori_kostum);
        kostum.setDeskripsi_kostum(deskripsi_kostum);
        request.setAttribute("pemilik", kostum);
        
        if (kode_kostum.equals("") || nama_kostum.equals("") || jumlah_kostum.equals("")
                 || kategori_kostum.equals("") || deskripsi_kostum.equals("")) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/error_page.jsp");
            message = "Data tidak lengkap, isi semua field dengan tanda (*) ";
            request.setAttribute("message", message);
            requestDispatcher.forward(request, response);
        } 
         else {
            
            dk.editKostum(kostum);
            
            RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/view_sukses.jsp");
                message = "Data kostum berhasil diubah";
                String page = "ListKostum";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
            }
    }
    
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditKostum</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditKostum at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
             PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        DaftarKostum dk = new DaftarKostum();
        Kostum kostum = new Kostum();
         
    
    String idi = request.getParameter("id");
        if (idi != null) {
            Long id = Long.parseLong(idi);
            kostum = (Kostum) dk.getDaftarKostum();
            request.setAttribute("kostum", kostum);
            dis = request.getRequestDispatcher("/EditKostum.jsp");
            dis.include(request, response);
        } else {
            response.sendRedirect("");
        }
    }
       
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
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

   
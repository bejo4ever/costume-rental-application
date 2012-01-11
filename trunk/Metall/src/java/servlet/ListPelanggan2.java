/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Pelanggan;
import entity.DaftarPelanggan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a
 */
public class ListPelanggan2 extends HttpServlet {

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
        HttpSession session = request.getSession();
        DaftarPelanggan dp = new DaftarPelanggan();
        Pelanggan p = new Pelanggan();
        //untuk mendapatkan session dari user yang telah login
        if (session.getAttribute("sessionusername") != null){
            String username = (String) session.getAttribute("sessionusername");
            //melakukan pengecekan untuk memastikan bahwa username telah terdaftar
            boolean hasilCheck = dp.checkPelanggan(username);
            if (hasilCheck) {
             //   p = dp.getPelangganFromName(username);
                 //username merupakan admin
                //if (dp.get == 0) {
                    //menyimpan daftar pelanggan dalam list
                    List<Pelanggan> plgn = dp.getPlgn();
                    request.setAttribute("pelanggan", plgn);
                    //diarahkan ke halaman daftar pelanggan
                    dis = request.getRequestDispatcher("/dftrplg.jsp");
                    dis.include(request, response);
//        try {
//            /* TODO output your page here
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ListPelanggan</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ListPelanggan at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//             */
//        } finally {            
//            out.close();
//        //}
    }}}

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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Pelanggan;
import entity.DaftarPelanggan;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Login2 extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        DaftarPelanggan daftarPelanggan = new DaftarPelanggan();
        String message = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Pelanggan plgn = daftarPelanggan.getPelanggan(username, password);

        //Kondisi jika username dan password ada yang tidak diisi
        try{
        if (username.equals("") || password.equals("")) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/error_login.jsp");
            message = "Username dan password harus diisi!";
            request.setAttribute("message", message);
            requestDispatcher.forward(request, response);
        } else {
            if (plgn != null) {
                session.setAttribute("sessionusername", username);
                if (plgn.getTipe() == 0) {
                    request.setAttribute("pelanggan", plgn);
                    dis = request.getRequestDispatcher("/HomeAdmin.jsp");
                    dis.include(request, response);
                } else if (plgn.getTipe() == 1) {
                    request.setAttribute("pelanggan", plgn);
                    dis = request.getRequestDispatcher("/HomePelanggan.jsp");
                    dis.include(request, response);
                }
                else{
                      RequestDispatcher requestDispatcher =
                            request.getRequestDispatcher("/error_page.jsp");
                    message ="Maaf, pendaftaran Anda belum dikonfirmasi!";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
                }
                }
                else {
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/error_login.jsp");
                message = "Username atau Password yang anda masukkan tidak cocok!";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        }
        }
    catch (NullPointerException npe){
    response.sendRedirect("../Login/");
    
    }}
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
    }}
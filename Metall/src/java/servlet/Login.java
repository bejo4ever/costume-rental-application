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
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Denia
 */
//@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            Pelanggan pelanggan = daftarPelanggan.getPelanggan(username,password);
           // Pelanggan user = new Pelanggan();
            // DaftarPelanggan dp = new DaftarPelanggan();
            //pelanggan.setUsername(username);
            //pelanggan.setPassword(password);
            
            //Kondisi jika username dan password ada yang tidak diisi
             if (username.equals("") || password.equals("") ) {
            RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/error_login.jsp");
                message ="Username dan password harus diisi!";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
              else{
            if (pelanggan != null) {
                    session.setAttribute("sessionusername", username);
                    if (pelanggan.getTipe() == 0) {
                        request.setAttribute("user", username);
                        dis = request.getRequestDispatcher("HomeAdmin.jsp");
                        dis.forward(request, response);
                    }
                    else if(username.getTipe() == 1) {
                        request.setAttribute("user", username);
                        dis = request.getRequestDispatcher("MenuUtamaPelanggan.jsp");
                        dis.forward(request, response);
                    }
                    /* else{
                        request.setAttribute("user", username);
                        dis = request.getRequestDispatcher("Login.jsp");
                        dis.forward(request, response);
                    }*/
                    
                    
        }
        else {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/error_login.jsp");
                    message ="Username atau Password yang anda masukkan tidak cocok!";
                    request.setAttribute("message", message);
                    requestDispatcher.forward(request, response);
        }}
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

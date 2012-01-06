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
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aQuWh iMoEtZ >,<
 */
//@WebServlet(name = "TambahPelanggan", urlPatterns = {"/tambahpelanggan"})
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
        RequestDispatcher dis = null;
        String message = null;
        HttpSession session = request.getSession();
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nama_pelanggan = request.getParameter("nama_pelanggan");
            String alamat_pelanggan = request.getParameter("alamat_pelanggan");
            String telpon_pelanggan = request.getParameter("telpon_pelanggan");
            //int tipe = Integer.parseInt(request.getParameter("tipe"));
            
            Pelanggan pelanggan = new Pelanggan();
            DaftarPelanggan dp = new DaftarPelanggan();
            RequestDispatcher requestDispatcher = null;
            
    
            if (username.equals("") || password.equals("") || nama_pelanggan.equals("")
                || alamat_pelanggan.equals("") || telpon_pelanggan.equals("")) {
            requestDispatcher =
                request.getRequestDispatcher("/error_page.jsp");
                message ="Data tidak lengkap, isi semua field dengan tanda (*) ";
                request.setAttribute("message", message);
                requestDispatcher.forward(request, response);
        }
        else{
            boolean hasilCheck = dp.checkPelanggan(username);
            if (!hasilCheck) {
            pelanggan.setUsername(username);
            pelanggan.setPassword(password);
            pelanggan.setNama_pelanggan(nama_pelanggan);
            pelanggan.setAlamat_pelanggan(alamat_pelanggan);
            pelanggan.setTelpon_pelanggan(telpon_pelanggan);
            //pelanggan.setTipe(tipe);
           
            dp.addPelanggan(pelanggan);
            List<Pelanggan> plgn = dp.getPlgn();
            request.setAttribute("pengguna", plgn);
             //diarahkan ke halaman daftar pelanggan
            requestDispatcher =
                        request.getRequestDispatcher("/SuccessSaving.jsp");
                message = "Pelanggan baru berhasil ditambahkan.";
                String page = "DaftarPelanggan";
                request.setAttribute("message", message);
                request.setAttribute("page", page);
                requestDispatcher.forward(request, response);
            } else {
                message ="Data Anda Berhasil Ditambahkan ";
                request.setAttribute("message", message);
                requestDispatcher = request.getRequestDispatcher("/SuccessSaving.jsp");
                    requestDispatcher.forward(request, response);
            }

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
        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        HttpSession session = request.getSession();
        DaftarPelanggan dp = new DaftarPelanggan();
        Pelanggan pelanggan = new Pelanggan();

        //mengambil parameter yang sudah dikirim dari halaman daftarPengguna.jsp

       
        //diarahkan ke halaman profil penyewa tempat
        dis = request.getRequestDispatcher("/TambahPelanggan.jsp");
        dis.include(request, response);

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

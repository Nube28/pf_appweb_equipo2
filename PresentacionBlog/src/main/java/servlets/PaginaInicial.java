/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Post;
import excepciones.PersistenciaException;
import interfaces.IPostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.PostDAO;

/**
 *
 * @author Berry
 */
@WebServlet(name = "PaginaInicial", urlPatterns = {"/PaginaInicial"})
public class PaginaInicial extends HttpServlet {

    

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IPostDAO postDAO = new PostDAO();
        try {
            List<Post> postsRecientes = postDAO.consultarPostMasRecientes();
            List<Post> postsRecientesFijados = postDAO.consultarPostFijadosMasRecientes();
            
            request.setAttribute("postsRecientes", postsRecientes);
            request.setAttribute("postsRecientesFijados", postsRecientesFijados);
            
            request.getRequestDispatcher("/logueado/paginaInicial.jsp").forward(request, response);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Comentario;
import entidades.Post;
import entidades.Usuario;
import interfaces.IComentarioDAO;
import interfaces.IPostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import persistencia.ComentarioDAO;
import persistencia.PostDAO;

/**
 *
 * @author Berry
 */

@WebServlet(name = "verPublicacion", urlPatterns = {"/verPublicacion"})
public class VerPublicacion extends HttpServlet {

    private final IPostDAO postDAO;
    private final IComentarioDAO comentarioDAO;
    
    public VerPublicacion() {
        this.postDAO = new PostDAO();
        this.comentarioDAO = new ComentarioDAO();
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdParam = request.getParameter("id");
        if (postIdParam == null || postIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de publicación no especificado");
            return;
        }

        try {
            Long postId = Long.valueOf(postIdParam);
            Post post = postDAO.consultarPostPorId(postId);
            List<Comentario> comentarios = comentarioDAO.consultarComentariosDelPost(post);
            
            Usuario autor = postDAO.consultarUsuarioPorPost(post);

            request.setAttribute("post", post);
            request.setAttribute("autor", autor);
            request.setAttribute("comentarios", comentarios);
            request.getRequestDispatcher("/verPublicacion.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al recuperar la publicación");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
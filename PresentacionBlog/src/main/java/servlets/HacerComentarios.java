/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Comentario;
import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IComentarioDAO;
import interfaces.IPostDAO;
import interfaces.IUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.tags.shaded.org.apache.bcel.generic.AALOAD;
import persistencia.ComentarioDAO;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

/**
 *
 * @author USER
 */
public class HacerComentarios extends HttpServlet {

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
        HttpSession session = request.getSession();
        try {
            IPostDAO postDAO = new PostDAO();
            IComentarioDAO comentarioDAO = new ComentarioDAO();
            Usuario usuario = (Usuario)session.getAttribute("usuarioLogueado");
            Long idPost = Long.parseLong(request.getParameter("idPost"));
            String contenidoComentario = request.getParameter("comentario");
            Post post = postDAO.consultarPostPorId(idPost);
            Comentario comentario=new Comentario(new Date(), contenidoComentario, usuario, post);
            comentarioDAO.hacerComentario(comentario);
            response.setStatus(200);
            response.getWriter().write(String.format("{\"id\": %d}", post.getId()));
        } catch (PersistenciaException ex) {
            Logger.getLogger(HacerComentarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        
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

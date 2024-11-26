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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "HacerComentarios", urlPatterns = {"/HacerComentarios"})
@MultipartConfig
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

            // Usuario logueado
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"error\": \"Usuario no autenticado\"}");
                return;
            }

            // Obtener parámetros
            String idPostStr = request.getParameter("idPost");
            Long idPost = Long.valueOf(idPostStr);
            String contenidoComentario = request.getParameter("comentario");

            // Buscar el post asociado
            Post post = postDAO.consultarPostPorId(idPost);
            if (post == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\": \"Post no encontrado\"}");
                return;
            }

            // Crear y asociar el comentario
            Comentario comentario = new Comentario(new Date(), contenidoComentario, usuario);
            comentario.setPost(post);
            comentarioDAO.hacerComentario(comentario);

            // Respuesta exitosa
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(String.format("{\"id\": %d}", post.getId()));

        } catch (PersistenciaException ex) {
            Logger.getLogger(HacerComentarios.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Ocurrió un error al procesar la solicitud\"}");
        } catch (Exception ex) {
            Logger.getLogger(HacerComentarios.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Solicitud inválida\"}");
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

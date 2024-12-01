/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.google.gson.Gson;
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
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        try {
//            IPostDAO postDAO = new PostDAO();
//            IComentarioDAO comentarioDAO = new ComentarioDAO();
//
//            Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
//
//            String idPostStr = request.getParameter("idPost");
//            Long idPost = Long.valueOf(idPostStr);
//            String contenidoComentario = request.getParameter("comentario");
//
//            Post post = postDAO.consultarPostPorId(idPost);
//
//            Comentario comentario = new Comentario(new Date(), contenidoComentario, usuario, post);
//            comentario.setPost(post);
//            comentarioDAO.hacerComentario(comentario);
//
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.getWriter().write(String.format("{\"id\": %d}", post.getId()));
//
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(HacerComentarios.class.getName()).log(Level.SEVERE, null, ex);
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write("{\"error\": \"Ocurrió un error al procesar la solicitud\"}");
//        } catch (Exception ex) {
//            Logger.getLogger(HacerComentarios.class.getName()).log(Level.SEVERE, null, ex);
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.getWriter().write("{\"error\": \"Solicitud inválida\"}");
//        }
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        IComentarioDAO comentarioDAO = new ComentarioDAO();
        IPostDAO postDAO = new PostDAO();

        try {
            String json = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            HacerComentarios.ComentarioData data = gson.fromJson(json, HacerComentarios.ComentarioData.class);

            Usuario usuario = usuarioDAO.buscarUsuarioPorID(data.getUsuarioId());

            Post post = postDAO.consultarPostPorId(data.getPostId());

            Comentario nuevoComentario = new Comentario(
                    new Date(),
                    data.getContenido(),
                    usuario,
                    post
            );
            comentarioDAO.hacerComentario(nuevoComentario);

        } catch (Exception e) {
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write("{\"error\":\"Ocurrió un error en el servidor\"}");
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
    }
    
    private static class ComentarioData {
        private String contenido;
        private Long usuarioId;
        private Long postId;

        public String getContenido() {
            return contenido;
        }

        public Long getUsuarioId() {
            return usuarioId;
        }

        public Long getPostId() {
            return postId;
        }
        
    }
}

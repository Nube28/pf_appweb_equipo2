package servlets;

import com.google.gson.Gson;
import entidades.Comentario;
import entidades.Post;
import entidades.Usuario;
import interfaces.IComentarioDAO;
import interfaces.IPostDAO;
import interfaces.IUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import persistencia.ComentarioDAO;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

/**
 *
 * @author Berry
 */
public class ComentarHijo extends HttpServlet {

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
    response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        IComentarioDAO comentarioDAO = new ComentarioDAO();
        IPostDAO postDAO = new PostDAO();
        
        try {
            String json = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            ComentarHijo.ComentarioData data = gson.fromJson(json, ComentarHijo.ComentarioData.class);

            Usuario usuario =  usuarioDAO.buscarUsuarioPorID(data.getUsuarioId());
            
            Comentario comentarioPadre = comentarioDAO.obtenerPorId(data.getComentarioPadreId());
            
            Post post = postDAO.consultarPostPorId(data.getPostId());

            Comentario nuevoComentario = new Comentario(
                    new Date(),
                    data.getContenido(),
                    usuario,
                    post,
                    comentarioPadre
            );
            comentarioPadre.addComentarioHijo(nuevoComentario);
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
        private Long comentarioPadreId;
        private Long postId;

        public String getContenido() {
            return contenido;
        }

        public Long getUsuarioId() {
            return usuarioId;
        }

        public Long getComentarioPadreId() {
            return comentarioPadreId;
        }

        public Long getPostId() {
            return postId;
        }
        
    }

}

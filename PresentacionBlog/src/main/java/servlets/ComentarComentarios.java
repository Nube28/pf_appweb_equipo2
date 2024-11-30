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
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.ComentarioDAO;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

@WebServlet(name = "ComentarComentarios", urlPatterns = {"/ComentarComentarios"})
public class ComentarComentarios extends HttpServlet {

    public ComentarComentarios() {
    }
    
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
            ComentarioData data = gson.fromJson(json, ComentarioData.class);

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
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write("{\"error\":\"Ocurrió un error en el servidor\"}");
        }
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
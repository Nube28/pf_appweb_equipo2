package mian;

import entidades.Comentario;
import entidades.Estado;
import entidades.Municipio;
import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IComentarioDAO;
import java.util.Date;
import persistencia.ComentarioDAO;
import persistencia.EstadoDAO;
import persistencia.MunicipioDAO;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

/**
 *
 * @author Berry
 */
public class nuab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        PostDAO postDAO = new PostDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        IComentarioDAO comentarioDAO = new ComentarioDAO();
        MunicipioDAO municipioDAO = new MunicipioDAO();
        EstadoDAO estadoDAO = new EstadoDAO();

        Usuario u = new Usuario("imgs/hardcodeadas/foto-perfil-admin.jpg", "admin", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
        Usuario u2 = new Usuario("imgs/hardcodeadas/foto-perfil.jpg", "papurri", "asda", "asdas", "asd@ola.com", "asd", "asda", new Date(), "otro", false);
        Usuario u3 = new Usuario("imgs/hardcodeadas/bell-foto-perfil.jpg", "bell", "asda", "asdas", "asd@ola.com", "asdf", "asda", new Date(), "otro", false);
        Usuario u4 = new Usuario("imgs/hardcodeadas/sidon.jpg", "Sidon", "asda", "asdas", "asd@ola.com", "asd", "asdafg", new Date(), "otro", false);

        Estado estado = new Estado(1L, "Oaxaca");

        Municipio municipio = new Municipio(1L, "Hermosillo");

        estadoDAO.agregarEstado(estado);
        municipioDAO.agregarMunicipio(municipio);

        u.setMunicipio(municipio);
        u.setEstado(estado);
        u2.setMunicipio(municipio);
        u2.setEstado(estado);
        u3.setMunicipio(municipio);
        u3.setEstado(estado);
        u4.setMunicipio(municipio);
        u4.setEstado(estado);

        usuarioDAO.registrarUsuario(u);
        usuarioDAO.registrarUsuario(u2);
        usuarioDAO.registrarUsuario(u3);
        usuarioDAO.registrarUsuario(u4);

        Usuario usu = usuarioDAO.buscarUsuarioPorID(1l);
        Usuario usu2 = usuarioDAO.buscarUsuarioPorID(2l);
        Usuario usu3 = usuarioDAO.buscarUsuarioPorID(3l);
        Usuario usu4 = usuarioDAO.buscarUsuarioPorID(4l);

        Post p = new Post(new Date(), "ESTE ES UN POST FIJADO", "conetendo contenido contenido contenido contenido", new Date(), "imgs/hardcodeadas/sidon.jpg", "imgs/hardcodeadas/sidon.jpg", true, usu2);
        Post p2 = new Post(new Date(), "ESTE ES UN POST normal1", "conetendo contenido contenido contenido contenido", new Date(), "imgs/hardcodeadas/emily.jpg", "imgs/hardcodeadas/emily.jpg", false, usu3);
        Post p3 = new Post(new Date(), "ESTE ES UN POST normal2", "conetendo contenido contenido contenido contenido", new Date(), "imgs/hardcodeadas/hatsunemiku.jpg", "imgs/hardcodeadas/hatsunemiku.jpg", false, usu4);
        Post p4 = new Post(new Date(), "ESTE ES UN POST normal3", "conetendo contenido contenido contenido contenido", new Date(), "imgs/hardcodeadas/sans.png", "", false, usu2);
        Post p5 = new Post(new Date(), "ESTE ES UN POST FIJADO2", "conetendo contenido contenido contenido contenido", new Date(), "imgs/hardcodeadas/reddead2.jpg", "imgs/hardcodeadas/reddead2.jpg", true, usu3);

        postDAO.hacerPost(p2);
        postDAO.hacerPost(p);
        postDAO.hacerPost(p3);
        postDAO.hacerPost(p4);
        postDAO.hacerPost(p5);

        Comentario comentarioPadre = new Comentario(new Date(), "Comentario padre", usu2, p2);
        comentarioDAO.hacerComentario(comentarioPadre);

        Comentario comentarioHijo = new Comentario(new Date(), "Comentario hijo", usu3, p2);
        comentarioPadre.addComentarioHijo(comentarioHijo);
        comentarioDAO.hacerComentario(comentarioHijo);

        System.out.println(postDAO.consultarPostFijadosMasRecientes());
    }

}

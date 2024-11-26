/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mian;

import entidades.Comentario;
import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ComentarioDAO;
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

        // Crear usuarios
        Post p = new Post(new Date(), "ESTE ES UN POST FIJADO", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sidon.jpg", true);
        Post p2 = new Post(new Date(), "ESTE ES UN POST normal1", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/emily.jpg", false);
        Post p3 = new Post(new Date(), "ESTE ES UN POST normal2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/hatsunemiku.jpg", false);
        Post p4 = new Post(new Date(), "ESTE ES UN POST normal3", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sans.jpg", false);
        Post p5 = new Post(new Date(), "ESTE ES UN POST FIJADO2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/reddead2.jpg", true);
        Usuario u = new Usuario("", "admin", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
        Usuario u2 = new Usuario("", "papurri", "asda", "asdas", "asd@ola.com", "asd", "asda", new Date(), "otro", false);
        usuarioDAO.registrarUsuario(u);
        usuarioDAO.registrarUsuario(u2);

        // Crear un post
        postDAO.hacerPost(p2);

        // Crear un comentario padre
        Comentario comentarioPadre = new Comentario(new Date(), "Comentario padre", u2);
        comentarioDAO.hacerComentario(comentarioPadre); // Persistir el comentario padre

        // Crear un comentario hijo
        Comentario comentarioHijo = new Comentario(new Date(), "Comentario hijo", u2);
        comentarioPadre.addComentarioHijo(comentarioHijo);
        comentarioDAO.hacerComentario(comentarioHijo); // Persistir el comentario hijo

        // Asociar el comentario padre al post
        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(comentarioPadre);
        p2.setComentarios(comentarios);
        postDAO.actualizar(p2); // Actualizar el post con los comentarios

        // Consultar posts fijados
        System.out.println(postDAO.consultarPostFijadosMasRecientes());
    }

}
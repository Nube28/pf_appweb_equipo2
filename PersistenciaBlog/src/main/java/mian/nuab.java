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
        UsuarioDAO usuarioDAO = new  UsuarioDAO();
        IComentarioDAO comentarioDAO = new ComentarioDAO();
        
        Post p = new Post(new Date(), "ESTE ES UN POST FIJADO", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sidon.jpg", true);
        Post p2 = new Post(new Date(), "ESTE ES UN POST normal1", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/emily.jpg", false);
        Post p3 = new Post(new Date(), "ESTE ES UN POST normal2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/hatsunemiku.jpg", false);
        Post p4 = new Post(new Date(), "ESTE ES UN POST normal3", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sans.jpg", false);
        Post p5 = new Post(new Date(), "ESTE ES UN POST FIJADO2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/reddead2.jpg", true);
        Usuario u = new Usuario("", "admin", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
        Usuario u2 = new Usuario("", "papurri", "asda", "asdas", "asd@ola.com", "asd", "asda", new Date(), "otro", false);
        
        Comentario comentario = new Comentario(new Date(), "Comentario padre", u2, p2);
        
        List<Comentario> comentarios = new ArrayList<>();
        
        comentarios.add(comentario);
        
        p2.setComentarios(comentarios);
        
        //ComentarioHijo comentarioHijo = new ComentarioHijo(new Date(), "Comentario hijo", u2);

        usuarioDAO.registrarUsuario(u);
        usuarioDAO.registrarUsuario(u2);
        postDAO.hacerPost(p);
        postDAO.hacerPost(p2);
        postDAO.hacerPost(p3);
        postDAO.hacerPost(p4);
        postDAO.hacerPost(p5);

        System.out.println(postDAO.consultarPostFijadosMasRecientes());
    }

}

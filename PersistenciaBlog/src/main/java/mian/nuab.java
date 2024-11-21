/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mian;

import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
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
        
        Post p = new Post(new Date(), "ESTE ES UN POST FIJADO", "conetendo contenido contenido contenido contenido", new Date(), "", "", true);
        Post p2 = new Post(new Date(), "ESTE ES UN POST normal1", "conetendo contenido contenido contenido contenido", new Date(), "", "", false);
        Post p3 = new Post(new Date(), "ESTE ES UN POST normal2", "conetendo contenido contenido contenido contenido", new Date(), "", "", false);
        Post p4 = new Post(new Date(), "ESTE ES UN POST normal3", "conetendo contenido contenido contenido contenido", new Date(), "", "", false);
        Post p5 = new Post(new Date(), "ESTE ES UN POST FIJADO2", "conetendo contenido contenido contenido contenido", new Date(), "", "", true);
        Usuario u = new Usuario("", "admin", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
        Usuario u2 = new Usuario("", "papurri", "asda", "asdas", "asd@ola.com", "asd", "asda", new Date(), "otro", false);
        
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

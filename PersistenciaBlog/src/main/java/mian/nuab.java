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
        Post p = new Post(new Date(), "as", "conetendo", new Date(), "", "");
        Usuario u = new Usuario("", "administrador cabeza de lado", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
        PostDAO aO = new PostDAO();
        UsuarioDAO aO1= new  UsuarioDAO();
        
        aO1.registrarUsuario(u);
        
        System.out.println(aO.consultarPostPorId(1l));
        
    }

}

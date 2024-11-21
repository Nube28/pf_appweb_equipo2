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
        Date date=new Date();
    Usuario u = new Usuario(
        "oas",
        "apellido",
        "apellido2",
        "SASA@ola.com",
        "asd",
        "2213as",
        date, // Aquí pasamos el Date
        "asdasd"
    );

    UsuarioDAO aO = new UsuarioDAO();
    aO.registrarUsuario(u);
    System.out.println("Se registró el usuario correctamente.");
}
    
}

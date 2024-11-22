package mian;

import entidades.Estado;
import entidades.Municipio;
import excepciones.PersistenciaException;
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
        MunicipioDAO municipioDAO = new MunicipioDAO();
        EstadoDAO estadoDAO = new EstadoDAO();

//        Post p = new Post(new Date(), "ESTE ES UN POST FIJADO", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sidon.jpg", true);
//        Post p2 = new Post(new Date(), "ESTE ES UN POST normal1", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/emily.jpg", false);
//        Post p3 = new Post(new Date(), "ESTE ES UN POST normal2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/hatsunemiku.jpg", false);
//        Post p4 = new Post(new Date(), "ESTE ES UN POST normal3", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/sans.jpg", false);
//        Post p5 = new Post(new Date(), "ESTE ES UN POST FIJADO2", "conetendo contenido contenido contenido contenido", new Date(), "", "imgs/hardcodeadas/reddead2.jpg", true);
//        Usuario u = new Usuario("", "admin", "asda", "asdas", "asd@ola.com", "1234", "asda", new Date(), "otro", true);
//        Usuario u2 = new Usuario("", "papurri", "asda", "asdas", "asd@ola.com", "asd", "asda", new Date(), "otro", false);

        Estado estado = new Estado("Oaxaca");
        Estado estado1 = new Estado("Sonora");
        Estado estado2 = new Estado("Sinaloa");

        Municipio municipio = new Municipio("Hermosillo");
        Municipio municipio1 = new Municipio("Guaymas");
        Municipio municipio2 = new Municipio("Nogales");

        municipioDAO.agregarMunicipio(municipio2);
        municipioDAO.agregarMunicipio(municipio);
        municipioDAO.agregarMunicipio(municipio1);

        estadoDAO.agregarEstado(estado1);
        estadoDAO.agregarEstado(estado2);
        estadoDAO.agregarEstado(estado);

//        usuarioDAO.registrarUsuario(u);
//        usuarioDAO.registrarUsuario(u2);
//        postDAO.hacerPost(p);
//        postDAO.hacerPost(p2);
//        postDAO.hacerPost(p3);
//        postDAO.hacerPost(p4);
//        postDAO.hacerPost(p5);

        //System.out.println(postDAO.consultarPostFijadosMasRecientes());
        System.out.println("ausilio");
    }

}

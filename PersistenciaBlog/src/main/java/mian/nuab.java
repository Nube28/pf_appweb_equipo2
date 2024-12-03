package mian;

import entidades.Comentario;
import entidades.Estado;
import entidades.Municipio;
import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        
        List<Estado> estados = new ArrayList<>();
        
        estados.add(new Estado(1L, "Aguascalientes"));
        estados.add(new Estado(2L, "Baja California"));
        estados.add(new Estado(3L, "Baja California Sur"));
        estados.add(new Estado(4L, "Campeche"));
        estados.add(new Estado(5L, "Chiapas"));
        estados.add(new Estado(6L, "Chihuahua"));
        estados.add(new Estado(7L, "Ciudad de México"));
        estados.add(new Estado(8L, "Coahuila"));
        estados.add(new Estado(9L, "Colima"));
        estados.add(new Estado(10L, "Durango"));
        estados.add(new Estado(11L, "Estado de México"));
        estados.add(new Estado(12L, "Guanajuato"));
        estados.add(new Estado(13L, "Guerrero"));
        estados.add(new Estado(14L, "Hidalgo"));
        estados.add(new Estado(15L, "Jalisco"));
        estados.add(new Estado(16L, "Michoacán"));
        estados.add(new Estado(17L, "Morelos"));
        estados.add(new Estado(18L, "Nayarit"));
        estados.add(new Estado(19L, "Nuevo León"));
        estados.add(new Estado(20L, "Oaxaca"));
        estados.add(new Estado(21L, "Puebla"));
        estados.add(new Estado(22L, "Querétaro"));
        estados.add(new Estado(23L, "Quintana Roo"));
        estados.add(new Estado(24L, "San Luis Potosí"));
        estados.add(new Estado(25L, "Sinaloa"));
        estados.add(new Estado(26L, "Sonora"));
        estados.add(new Estado(27L, "Tabasco"));
        estados.add(new Estado(28L, "Tamaulipas"));
        estados.add(new Estado(29L, "Tlaxcala"));
        estados.add(new Estado(30L, "Veracruz"));
        estados.add(new Estado(31L, "Yucatán"));
        estados.add(new Estado(32L, "Zacatecas"));
        
        for (Estado estado : estados) {
            estadoDAO.agregarEstado(estado);
        }
        
        List<Municipio> municipios = new ArrayList<>();
        
        municipios.add(new Municipio(1L, "Hermosillo"));
        municipios.add(new Municipio(2L, "Cajeme"));
        municipios.add(new Municipio(3L, "Nogales"));
        municipios.add(new Municipio(4L, "San Luis Río Colorado"));
        municipios.add(new Municipio(5L, "Guaymas"));
        municipios.add(new Municipio(6L, "Navojoa"));
        municipios.add(new Municipio(7L, "Agua Prieta"));
        municipios.add(new Municipio(8L, "Caborca"));
        municipios.add(new Municipio(9L, "Empalme"));
        municipios.add(new Municipio(10L, "Cananea"));
        municipios.add(new Municipio(11L, "Etchojoa"));
        municipios.add(new Municipio(12L, "Puerto Peñasco"));
        municipios.add(new Municipio(13L, "Magdalena de Kino"));
        municipios.add(new Municipio(14L, "Bácum"));
        municipios.add(new Municipio(15L, "Álamos"));
        
        for (Municipio municipio : municipios) {
            municipioDAO.agregarMunicipio(municipio);
        }
        
        u.setMunicipio(municipios.getFirst());
        u.setEstado(estados.getLast());
        u2.setMunicipio(municipios.getLast());
        u2.setEstado(estados.getFirst());
        u3.setMunicipio(municipios.getFirst());
        u3.setEstado(estados.getLast());
        u4.setMunicipio(municipios.getLast());
        u4.setEstado(estados.getFirst());
        
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

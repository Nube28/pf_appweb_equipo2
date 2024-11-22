package imagenes;

import entidades.Post;
import excepciones.PersistenciaException;
import interfaces.IPostDAO;
import java.io.IOException;

public class LogicaPost {
    private final IPostDAO postDAO;

    public LogicaPost(IPostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public boolean guardarPostConImagen(Post post, byte[] imagen, String nombreImagen) throws PersistenciaException {
        String rutaImagen = "img";
        try {
            String rutaCompleta = ImageUtileria.guardarImagen(imagen, nombreImagen, rutaImagen);

            post.setUrlImagen(rutaCompleta);

            return postDAO.hacerPost(post);
        } catch (IOException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al guardar la imagen del post", e);
        }
    }
}

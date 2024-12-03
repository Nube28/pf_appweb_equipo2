package interfaces;

import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz para PostDAO
 *
 * @author USER
 */
public interface IPostDAO {

    /**
     * Crea un nuevo post en la base de datos.
     *
     * @param post El objeto Post a persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al persistir el post.
     */
    public boolean hacerPost(Post post) throws PersistenciaException;

    /**
     * Actualiza un post existente en la base de datos.
     *
     * @param post El objeto Post con los cambios a aplicar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al actualizar el post.
     */
    public boolean editarPost(Post post) throws PersistenciaException;

    /**
     * Elimina un post de la base de datos.
     *
     * @param post El objeto Post que se desea eliminar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al eliminar el post.
     */
    public boolean eliminarPost(Post post) throws PersistenciaException;

    /**
     * Consulta todos los posts realizados por un usuario específico.
     *
     * @param usuario El objeto Usuario del que se quieren obtener los posts.
     * @return Una lista de posts del usuario.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Post> consultarPostsDelUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Consulta los posts más recientes (excluyendo los fijados).
     *
     * @return Una lista de los posts más recientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Post> consultarPostMasRecientes() throws PersistenciaException;

    /**
     * Consulta el usuario asociado a un post.
     *
     * @param post El objeto Post cuyo autor se desea consultar.
     * @return El usuario asociado al post.
     * @throws PersistenciaException Si no se encuentra el usuario o hay un
     * error en la consulta.
     */
    public Usuario consultarUsuarioPorPost(Post post) throws PersistenciaException;

    /**
     * Consulta los posts más recientes (excluyendo los fijados).
     *
     * @return Una lista de los posts más recientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Post consultarPostPorId(Long id) throws PersistenciaException;

    /**
     * Consulta los posts fijados más recientes.
     *
     * @return Una lista de los posts fijados más recientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public List<Post> consultarPostFijadosMasRecientes() throws PersistenciaException;

    /**
     * Cambia el estado de "fijado" de un post.
     *
     * @param postId El ID del post cuyo estado se desea cambiar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si no se encuentra el post o ocurre un
     * error.
     */
    public boolean cambiarFijado(Long postId) throws PersistenciaException;

}

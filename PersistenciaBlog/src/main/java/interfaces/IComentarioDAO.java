package interfaces;

import entidades.Comentario;
import entidades.Post;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * 
 * Interfaz para ComentarioDAO
 *
 * @author USER
 */
public interface IComentarioDAO {

    /**
     * Registra un nuevo comentario en la base de datos.
     *
     * @param comentario El comentario a persistir.
     * @return true si la operación fue exitosa, {@code false} en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean hacerComentario(Comentario comentario) throws PersistenciaException;

    /**
     * Actualiza la información de un comentario existente.
     *
     * @param comentario El comentario con los datos actualizados.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean editarComentario(Comentario comentario) throws PersistenciaException;

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario El comentario a eliminar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean eliminarComentario(Comentario comentario) throws PersistenciaException;

    /**
     * Obtiene los comentarios principales de un post (aquellos sin comentarios
     * padres).
     *
     * @param post El post del cual se obtendrán los comentarios.
     * @return Una lista de comentarios principales.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Comentario> consultarComentariosDelPost(Post post) throws PersistenciaException;

    /**
     * Obtiene los comentarios hijos de un post (aquellos que tienen un
     * comentario padre).
     *
     * @param post El post del cual se obtendrán los comentarios hijos.
     * @return Una lista de comentarios hijos.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<Comentario> consultarComentariosHijosDelPost(Post post) throws PersistenciaException;

    /**
     * Busca un comentario específico por su ID.
     *
     * @param id El ID del comentario a buscar.
     * @return El comentario encontrado.
     * @throws PersistenciaException Si no se encuentra el comentario o si
     * ocurre un error.
     */
    public Comentario obtenerPorId(Long id) throws PersistenciaException;
}

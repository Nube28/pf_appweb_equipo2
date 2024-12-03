package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Comentario;
import entidades.Post;
import excepciones.PersistenciaException;
import interfaces.IComentarioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * Clase para gestionar la persistencia de los comentarios.
 *
 * @author USER
 */
public class ComentarioDAO implements IComentarioDAO {

    private final IConexion conexion;

    /**
     * Constructor por defecto.
     */
    public ComentarioDAO() {
        conexion = new Conexion();
    }

    /**
     * Registra un nuevo comentario en la base de datos.
     *
     * @param comentario El comentario a persistir.
     * @return true si la operación fue exitosa
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    @Override
    public boolean hacerComentario(Comentario comentario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.persist(comentario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al hacer el comentario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza la información de un comentario existente.
     *
     * @param comentario El comentario con los datos actualizados.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    @Override
    public boolean editarComentario(Comentario comentario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.merge(comentario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al editar el comentario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario El comentario a eliminar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    @Override
    public boolean eliminarComentario(Comentario comentario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.remove(comentario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el comentario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene los comentarios principales de un post (aquellos sin comentarios
     * padres).
     *
     * @param post El post del cual se obtendrán los comentarios.
     * @return Una lista de comentarios principales.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Comentario> consultarComentariosDelPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            List<Comentario> comentarios = em.createQuery(
                    "SELECT c FROM Comentario c WHERE c.post.id = :postId AND c.comentarioPadre IS NULL", Comentario.class)
                    .setParameter("postId", post.getId())
                    .getResultList();
            return comentarios;
        } catch (NoResultException e) {
            throw new PersistenciaException("Este post no tiene comentarios aún", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener los comentarios", e);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene los comentarios hijos de un post (aquellos que tienen un
     * comentario padre).
     *
     * @param post El post del cual se obtendrán los comentarios hijos.
     * @return Una lista de comentarios hijos.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    @Override
    public List<Comentario> consultarComentariosHijosDelPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            List<Comentario> comentariosHijos = em.createQuery(
                    "SELECT c FROM Comentario c WHERE c.post.id = :postId AND c.comentarioPadre IS NOT NULL", Comentario.class)
                    .setParameter("postId", post.getId())
                    .getResultList();
            return comentariosHijos;
        } catch (NoResultException e) {
            throw new PersistenciaException("Este post no tiene comentarios hijos aún", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener los comentarios hijos", e);
        } finally {
            em.close();
        }
    }

    /**
     * Busca un comentario específico por su ID.
     *
     * @param id El ID del comentario a buscar.
     * @return El comentario encontrado.
     * @throws PersistenciaException Si no se encuentra el comentario o si
     * ocurre un error.
     */
    @Override
    public Comentario obtenerPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            // Busca el comentario por su ID
            Comentario comentario = em.find(Comentario.class, id);
            if (comentario == null) {
                throw new PersistenciaException("No se encontró ningún comentario con el ID proporcionado.");
            }
            return comentario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener el comentario por ID.", e);
        } finally {
            em.close();
        }
    }

}

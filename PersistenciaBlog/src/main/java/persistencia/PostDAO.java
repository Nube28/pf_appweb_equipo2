package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IPostDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * Clase para gestionar la persistencia de los posts.
 *
 * @author USER
 */
public class PostDAO implements IPostDAO {

    private final IConexion conexion;

    /**
     * Constructor por ausencia
     */
    public PostDAO() {
        conexion = new Conexion();
    }

    /**
     * Crea un nuevo post en la base de datos.
     *
     * @param post El objeto Post a persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al persistir el post.
     */
    @Override
    public boolean hacerPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al hacer el post", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Actualiza un post existente en la base de datos.
     *
     * @param post El objeto Post con los cambios a aplicar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al actualizar el post.
     */
    @Override
    public boolean editarPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.merge(post);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al editar el post", e);
        } finally {
            em.close();
        }

    }

    /**
     * Elimina un post de la base de datos.
     *
     * @param post El objeto Post que se desea eliminar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al eliminar el post.
     */
    @Override
    public boolean eliminarPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Post managedPost = em.contains(post) ? post : em.find(Post.class, post.getId());

            if (managedPost != null) {
                em.remove(managedPost);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                throw new PersistenciaException("El post no existe en la base de datos.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el post", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta todos los posts realizados por un usuario específico.
     *
     * @param usuario El objeto Usuario del que se quieren obtener los posts.
     * @return Una lista de posts del usuario.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Post> consultarPostsDelUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            List<Post> posts = em.createQuery(
                    "SELECT p FROM posts p WHERE p.usuario_id = :idusuario ",
                    Post.class)
                    .setParameter("idusuario", usuario.getId())
                    .getResultList();
            em.getTransaction().commit();
            return posts;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Este usuario aun no hace posts");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener los posts", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta el usuario asociado a un post.
     *
     * @param post El objeto Post cuyo autor se desea consultar.
     * @return El usuario asociado al post.
     * @throws PersistenciaException Si no se encuentra el usuario o hay un
     * error en la consulta.
     */
    @Override
    public Usuario consultarUsuarioPorPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Usuario usuario = em.createQuery(
                    "SELECT p.usuario FROM Post p WHERE p.id = :idPost",
                    Usuario.class)
                    .setParameter("idPost", post.getId())
                    .getSingleResult();
            em.getTransaction().commit();
            return usuario;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se encontró un usuario asociado al post proporcionado.", e);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar el usuario del post.", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta un post por su ID.
     *
     * @param id El identificador del post.
     * @return El objeto Post correspondiente.
     * @throws PersistenciaException Si no se encuentra el post o hay un error
     * en la consulta.
     */
    @Override
    public Post consultarPostPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Post post = em.createQuery(
                    "SELECT p FROM Post p WHERE p.id = :id",
                    Post.class)
                    .setParameter("id", id)
                    .getSingleResult();
            em.getTransaction().commit();
            return post;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se encontró ningún post con el ID proporcionado.", e);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar el post por ID.", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta los posts más recientes (excluyendo los fijados).
     *
     * @return Una lista de los posts más recientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Post> consultarPostMasRecientes() throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            String jpql = "SELECT p FROM Post p WHERE p.fijado = false ORDER BY p.fechaHoraCreacion DESC";
            TypedQuery<Post> query = em.createQuery(jpql, Post.class);
            query.setMaxResults(10);
            return query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar el post por ID.", e);
        }
    }

    /**
     * Consulta los posts fijados más recientes.
     *
     * @return Una lista de los posts fijados más recientes.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Post> consultarPostFijadosMasRecientes() throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            String jpql = "SELECT p FROM Post p WHERE p.fijado = true ORDER BY p.fechaHoraCreacion DESC";
            TypedQuery<Post> query = em.createQuery(jpql, Post.class);
            query.setMaxResults(10);
            List<Post> posts = query.getResultList();
            em.getTransaction().commit();
            return posts;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar los posts fijados más recientes.", e);
        } finally {
            em.close();
        }
    }

    /**
     * Cambia el estado de "fijado" de un post.
     *
     * @param postId El ID del post cuyo estado se desea cambiar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si no se encuentra el post o ocurre un
     * error.
     */
    @Override
    public boolean cambiarFijado(Long postId) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Post post = em.find(Post.class, postId);
            if (post == null) {
                throw new PersistenciaException("No se encontró ningún post con el ID proporcionado.");
            }
            post.setFijado(!post.getFijado());
            em.merge(post);
            em.getTransaction().commit();
            return true;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw e;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al cambiar el estado de fijado del post.", e);
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza un post existente en la base de datos.
     *
     * @param post El objeto {@link Post} con los cambios a aplicar.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error al actualizar el post.
     */
    public boolean actualizar(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.merge(post);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al actualizar el post", e);
        } finally {
            em.close();
        }
    }

}

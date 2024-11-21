/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author USER
 */
public class PostDAO implements IPostDAO {

    private final IConexion conexion;

    public PostDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean hacerPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.persist(post);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al hacer el post", e);
        } finally {
            em.close();
        }
    }

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

    @Override
    public boolean eliminarPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.remove(post);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el post", e);
        } finally {
            em.close();
        }
    }

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

}

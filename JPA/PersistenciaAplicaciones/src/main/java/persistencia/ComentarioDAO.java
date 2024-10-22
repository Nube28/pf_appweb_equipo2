/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author USER
 */
public class ComentarioDAO implements IComentarioDAO{
    
    private final IConexion conexion;

    public ComentarioDAO() {
        conexion = new Conexion();
    }
    

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

    @Override
    public List<Comentario> consultarComentariosDelPost(Post post) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            List<Comentario> comentarios = em.createQuery(
                    "SELECT c FROM comentarios c WHERE c.post_id = :idpost ",
                    Comentario.class)
                    .setParameter("idpost", post.getId())
                    .getResultList();
            em.getTransaction().commit();
            return comentarios;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Este post no tiene comentarios aún");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener los comentarios", e);
        } finally {
            em.close();
        }
    }
    
}

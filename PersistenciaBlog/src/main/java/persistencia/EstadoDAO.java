package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Estado;
import excepciones.PersistenciaException;
import interfaces.IEstadoDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Katt
 */
public class EstadoDAO implements IEstadoDAO {

    private final IConexion conexion;

    public EstadoDAO() {
        conexion = new Conexion();
    }

    public boolean agregarEstado(Estado estados) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.persist(estados);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al agregar un estado", e);
        } finally {
            em.close();
        }
    }

    public boolean eliminarEstado(Estado estados) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.remove(estados);
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

    public List<Estado> consultarEstadosPorId(Estado estados) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            List<Estado> esta2 = em.createQuery(
                    "SELECT e FROM Estado e WHERE e.id = :id",
                    Estado.class)
                    .setParameter("id", estados.getId())
                    .getResultList();

            em.getTransaction().commit();
            return esta2;

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar los estados", e);
        } finally {
            em.close();
        }
    }

}

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
        try {
            em.getTransaction().begin();
            em.persist(estados);
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

}

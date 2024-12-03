package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Estado;
import excepciones.PersistenciaException;
import interfaces.IEstadoDAO;
import javax.persistence.EntityManager;

/**
 *
 * Clase para gestionar la persistencia de los estados.
 *
 * @author Katt
 */
public class EstadoDAO implements IEstadoDAO {

    private final IConexion conexion;

    /**
     * Constructor por ausencia
     */
    public EstadoDAO() {
        conexion = new Conexion();
    }

    /**
     * Agrega un nuevo estado a la base de datos.
     *
     * @param estados El objeto de tipo Estado que se desea persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
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
            throw new PersistenciaException("Error al persistir", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

}

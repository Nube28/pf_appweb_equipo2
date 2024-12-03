package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Municipio;
import excepciones.PersistenciaException;
import interfaces.IMunicipioDAO;
import javax.persistence.EntityManager;

/**
 * 
 * Clase para gestionar la persistencia de los municipios.
 *
 * @author Katt
 */
public class MunicipioDAO implements IMunicipioDAO {

    private final IConexion conexion;

    /**
     * Constructor por ausencia.
     */
    public MunicipioDAO() {
        conexion = new Conexion();
    }

    /**
     * Agrega un nuevo municipio a la base de datos.
     * 
     * @param municipios El objeto de tipo Municipio que se desea persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean agregarMunicipio(Municipio municipios) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.persist(municipios);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al hacer al persistir", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

}

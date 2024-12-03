package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Municipio;
import excepciones.PersistenciaException;
import interfaces.IMunicipioDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Katt
 */
public class MunicipioDAO implements IMunicipioDAO {

    private final IConexion conexion;

    public MunicipioDAO() {
        conexion = new Conexion();
    }

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
            throw new PersistenciaException("Error al hacer el post", e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

}

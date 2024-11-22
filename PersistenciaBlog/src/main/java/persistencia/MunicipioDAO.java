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
        em.getTransaction().begin();

        try {
            em.persist(municipios);
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

    public boolean eliminarMunicipio(Municipio municipios) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.remove(municipios);
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

    public List<Municipio> consultarMunicipiosPorId(Municipio municipios) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            List<Municipio> munici = em.createQuery(
                    "SELECT m FROM Municipio m WHERE m.id = :id",
                    Municipio.class)
                    .setParameter("id", municipios.getId())
                    .getResultList();

            em.getTransaction().commit();
            return munici;

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar los municipios", e);
        } finally {
            em.close();
        }
    }

}

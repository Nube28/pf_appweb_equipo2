package conexionEM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion implements IConexion {

    /**
     * Abre una conexión con la base de datos utilizando JPA.
     *
     * @return Un objeto EntityManager que representa la conexión establecida.
     */
    @Override
    public EntityManager abrir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}

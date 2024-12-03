package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * Clase para gestionar la persistencia de los usuarios.
 *
 * @author USER
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final IConexion conexion;

    /**
     * Constctor por ausencia
     */
    public UsuarioDAO() {
        conexion = new Conexion();
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto {@link Usuario} que se desea persistir.
     * @return true si el usuario se registró con éxito.
     * @throws PersistenciaException Si ocurre un error durante el registro.
     */
    @Override
    public boolean registrarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.persist(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al registrar el usuario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    @Override
    public boolean editarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.merge(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al editar el usuario", e);
        } finally {
            em.close();
        }

    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El objeto Usuario que se desea eliminar.
     * @return true si el usuario se eliminó con éxito.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public boolean eliminarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.remove(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el usuario", e);
        } finally {
            em.close();
        }
    }

    /**
     * Encuentra un usuario por su correo y contraseña.
     *
     * @param correo El correo del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El objeto Usuario si existe, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public Usuario encontrarUsuarioPorCorreoYContrasena(String correo, String contrasenia) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia", contrasenia);
            Usuario usuario = query.getResultList().stream().findFirst().orElse(null);

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al encontrar el usuario por correo y contraseña", e);
        } finally {
            em.close();
        }
    }

    /**
     * Comprueba si un usuario ya existe en la base de datos por su correo
     * electrónico.
     *
     * @param correo El correo del usuario.
     * @return true si el usuario ya existe
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public boolean comprobarUsuarioExistente(String correo) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("correo", correo);
            Usuario usuario = query.getResultList().stream().findFirst().orElse(null);
            if (usuario == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException("Error", e);
        }

    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El identificador del usuario.
     * @return El objeto Usuario si se encuentra.
     * @throws PersistenciaException Si no se encuentra el usuario o ocurre un
     * error durante la consulta.
     */
    @Override
    public Usuario buscarUsuarioPorID(Long id) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            Usuario usuario = em.createQuery(
                    "SELECT p FROM Usuario p WHERE p.id = :id",
                    Usuario.class)
                    .setParameter("id", id)
                    .getSingleResult();
            em.getTransaction().commit();
            return usuario;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se encontró ningún usuario con el ID proporcionado.", e);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al consultar el usuario por ID.", e);
        } finally {
            em.close();
        }
    }

}

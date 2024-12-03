package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 * Interfaz para UsuarioDAO
 *
 * @author USER
 */
public interface IUsuarioDAO {

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto {@link Usuario} que se desea persistir.
     * @return true si el usuario se registró con éxito.
     * @throws PersistenciaException Si ocurre un error durante el registro.
     */
    public boolean registrarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    public boolean editarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El objeto Usuario que se desea eliminar.
     * @return true si el usuario se eliminó con éxito.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    public boolean eliminarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Encuentra un usuario por su correo y contraseña.
     *
     * @param correo El correo del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El objeto Usuario si existe, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Usuario encontrarUsuarioPorCorreoYContrasena(String correo, String contrasena) throws PersistenciaException;

    /**
     * Comprueba si un usuario ya existe en la base de datos por su correo
     * electrónico.
     *
     * @param correo El correo del usuario.
     * @return true si el usuario ya existe
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public boolean comprobarUsuarioExistente(String correo) throws PersistenciaException;

    /**
     * Busca un usuario por su ID.
     *
     * @param id El identificador del usuario.
     * @return El objeto Usuario si se encuentra.
     * @throws PersistenciaException Si no se encuentra el usuario o ocurre un
     * error durante la consulta.
     */
    public Usuario buscarUsuarioPorID(Long id) throws PersistenciaException;

}

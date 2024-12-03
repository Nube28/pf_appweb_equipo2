package interfaces;

import entidades.Estado;
import excepciones.PersistenciaException;

/**
 * Interfz para EstadoDAO
 *
 * @author Katt
 */
public interface IEstadoDAO {

    /**
     * Agrega un nuevo estado a la base de datos.
     *
     * @param estados El objeto de tipo Estado que se desea persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean agregarEstado(Estado estados) throws PersistenciaException;

}

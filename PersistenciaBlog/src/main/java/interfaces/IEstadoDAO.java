package interfaces;

import entidades.Estado;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt
 */
public interface IEstadoDAO {

    public boolean agregarEstado(Estado estados) throws PersistenciaException;

    public boolean eliminarEstado(Estado estados) throws PersistenciaException;

    public List<Estado> consultarEstadosPorId(Estado estados) throws PersistenciaException;

}

package interfaces;

import entidades.Municipio;
import excepciones.PersistenciaException;

/**
 * Interfaz para MunicipioDAO
 *
 * @author Katt
 */
public interface IMunicipioDAO {

    /**
     * Agrega un nuevo municipio a la base de datos.
     *
     * @param municipios El objeto de tipo Municipio que se desea persistir.
     * @return true si la operación fue exitosa.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    public boolean agregarMunicipio(Municipio municipios) throws PersistenciaException;

}

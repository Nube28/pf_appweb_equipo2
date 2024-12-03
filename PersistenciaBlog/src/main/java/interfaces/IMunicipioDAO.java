package interfaces;

import entidades.Municipio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Katt
 */
public interface IMunicipioDAO {

    public boolean agregarMunicipio(Municipio municipios) throws PersistenciaException;

}
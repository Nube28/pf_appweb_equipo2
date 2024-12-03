package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Clase que representa la entidad Municipio
 *
 * @author USER
 */
@Entity
@Table(name = "Municipios")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "municipio")
    private List<Usuario> usuarios = new ArrayList<>();

    /**
     * Constructor por ausencia
     */
    public Municipio() {
    }

    /**
     * Constructor que crea un Municipio
     *
     * @param id el identificador único del municipio
     * @param nombre el nombre del municipio
     * @param usuarios la lista de usuarios asociados al municipio
     */
    public Municipio(Long id, String nombre, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    /**
     * Constructor que crea un Municipio
     *
     * @param nombre el nombre del municipio
     * @param usuarios la lista de usuarios asociados al municipio
     */
    public Municipio(String nombre, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    /**
     * Constructor que crea un Municipio
     *
     * @param id el identificador único del municipio
     * @param nombre el nombre del municipio
     */
    public Municipio(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Devuelve el identificador único del municipio.
     *
     * @return el identificador único del municipio
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del municipio.
     *
     * @param id el identificador único del municipio
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del municipio.
     *
     * @return el nombre del municipio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     *
     * @param nombre el nombre del municipio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de usuarios asociados al municipio.
     *
     * @return la lista de usuarios asociados al municipio
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios asociados al municipio.
     *
     * @param usuarios la lista de usuarios asociados al municipio
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

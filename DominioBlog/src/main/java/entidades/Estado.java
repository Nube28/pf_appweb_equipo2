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
 * Clase que representa un estado de un usuario.
 *
 * @author USER
 */
@Entity
@Table(name = "Estados")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<Usuario> usuario = new ArrayList<>();

    /**
     * Constructor por ausencia
     */
    public Estado() {
    }

    /**
     * Constructor que inicializa una nueva instancia de la clase Estado.
     *
     * @param id El identificador del estado.
     * @param nombre El nombre del estado.
     * @param usuario La lista de usuarios que tienen este estado.
     */
    public Estado(Long id, String nombre, List<Usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    /**
     * Constructor que inicializa una nueva instancia de la clase Estado.
     *
     * @param nombre El nombre del estado.
     * @param usuario La lista de usuarios que tienen este estado.
     */
    public Estado(String nombre, List<Usuario> usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    /**
     * Constructor que inicializa una nueva instancia de la clase Estado.
     *
     * @param id El identificador del estado.
     * @param nombre El nombre del estado.
     */
    public Estado(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Regresa el identificador del estado.
     *
     * @return id El identificador del estado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Agrega el identificador del estado.
     *
     * @param id El identificador del estado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Regresa el nombre del estado.
     *
     * @return nombre El nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega el nombre del estado.
     *
     * @param nombre El nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la lista de usuarios que tienen este estado.
     *
     * @return usuario La lista de usuarios que tienen este estado.
     */
    public List<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * Agrega la lista de usuarios que tienen este estado.
     *
     * @param usuario La lista de usuarios que tienen este estado.
     */
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

}

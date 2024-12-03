package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Usuario.
 *
 * @author USER
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "urlAvatar", nullable = false)
    private String urlAvatar;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = true)
    private String apellidoMaterno;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "tipo", nullable = false)
    private Boolean tipo;

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @ManyToOne(optional = true)
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;

    @ManyToOne(optional = true)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    /**
     * Constructor por ausencia
     */
    public Usuario() {
    }

    /**
     * Constructor con todos los atributos importantes para la creación de un
     * Usuario.
     *
     * @param urlAvatar URL del avatar del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario (opcional)
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     * @param telefono Teléfono del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param genero Género del usuario
     * @param tipo Tipo de usuario 
     */
    public Usuario(String urlAvatar, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, Date fechaNacimiento, String genero, Boolean tipo) {
        this.urlAvatar = urlAvatar;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.tipo = tipo;
    }

    /**
     * Constructor con todos los atributos y el ID para la creación de un
     * Usuario.
     *
     * @param id Identificador único del usuario
     * @param urlAvatar URL del avatar del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario (opcional)
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     * @param telefono Teléfono del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param genero Género del usuario
     */
    public Usuario(Long id, String urlAvatar, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, String telefono, Date fechaNacimiento, String genero) {
        this.id = id;
        this.urlAvatar = urlAvatar;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El identificador único del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El apellido paterno del usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El apellido materno del usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return El teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono El teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el género del usuario.
     *
     * @return El género del usuario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero El género del usuario.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el municipio al que pertenece el usuario.
     *
     * @return El municipio del usuario.
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio al que pertenece el usuario.
     *
     * @param municipio El municipio del usuario.
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el estado al que pertenece el usuario.
     *
     * @return El estado del usuario.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado al que pertenece el usuario.
     *
     * @param estado El estado del usuario.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la URL del avatar del usuario.
     *
     * @return La URL del avatar del usuario.
     */
    public String getUrlAvatar() {
        return urlAvatar;
    }

    /**
     * Establece la URL del avatar del usuario.
     *
     * @param urlAvatar La URL del avatar del usuario.
     */
    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    /**
     * Obtiene el tipo de usuario
     *
     * @return El tipo de usuario.
     */
    public Boolean getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario
     *
     * @param tipo El tipo de usuario.
     */
    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
}

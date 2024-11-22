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

    @Column(name = "apellidoMaterno", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "municipio", referencedColumnName = "id")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id")
    private Estado estado;

    public Usuario() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", posts=" + posts + ", comentarios=" + comentarios + ", municipio=" + municipio + ", estado=" + estado + '}';
    }

}

package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
 * Clase que representa un Post en la base de datos.
 *
 * @author USER
 */
@Entity
@Table(name = "Posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHoraCreacion", nullable = false)
    private Date fechaHoraCreacion;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fechaHoraEdicion", nullable = true)
    private Date fechaHoraEdicion;

    @Column(name = "urlImagenPortada", nullable = false)
    private String urlImagenPortada;

    @Column(name = "urlImagen", nullable = true)
    private String urlImagen;

    @Column(name = "fijado", nullable = false)
    private Boolean fijado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id") // Crea la clave foránea en Comentario
    private List<Comentario> comentarios = new ArrayList<>();

    /**
     * Constructor por ausencia
     */
    public Post() {
    }

    /**
     * Constructor que crea un Post
     *
     * @param fechaHoraCreacion la fecha y hora de creación del post
     * @param titulo el título del post
     * @param contenido el contenido del post
     * @param fechaHoraEdicion la fecha y hora de edición del post
     * @param urlImagenPortada la URL de la imagen de portada
     * @param urlImagen la URL de la imagen adicional
     * @param fijado el estado de si el post está fijado o no
     * @param usuario el usuario que creó el post
     */
    public Post(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String urlImagenPortada, String urlImagen, Boolean fijado, Usuario usuario) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.urlImagenPortada = urlImagenPortada;
        this.urlImagen = urlImagen;
        this.fijado = fijado;
        this.usuario = usuario;
    }

    /**
     * Constructor que crea un Post
     *
     * @param id el identificador único del post
     * @param fechaHoraCreacion la fecha y hora de creación del post
     * @param titulo el título del post
     * @param contenido el contenido del post
     * @param fechaHoraEdicion la fecha y hora de edición del post
     * @param urlImagenPortada la URL de la imagen de portada
     * @param urlImagen la URL de la imagen adicional
     * @param fijado el estado de si el post está fijado o no
     * @param usuario el usuario que creó el post
     */
    public Post(Long id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String urlImagenPortada, String urlImagen, Boolean fijado, Usuario usuario) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.urlImagenPortada = urlImagenPortada;
        this.urlImagen = urlImagen;
        this.fijado = fijado;
        this.usuario = usuario;
    }

    /**
     * Devuelve el identificador único del post.
     *
     * @return el identificador único del post
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del post.
     *
     * @param id el identificador único del post
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha y hora de creación del post.
     *
     * @return la fecha y hora de creación del post
     */
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación del post.
     *
     * @param fechaHoraCreacion la fecha y hora de creación del post
     */
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Devuelve el título del post.
     *
     * @return el título del post
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del post.
     *
     * @param titulo el título del post
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el contenido del post.
     *
     * @return el contenido del post
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del post.
     *
     * @param contenido el contenido del post
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve la fecha y hora en que se editó el post.
     *
     * @return la fecha y hora de edición del post
     */
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora en que se editó el post.
     *
     * @param fechaHoraEdicion la fecha y hora de edición del post
     */
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Devuelve la URL de la imagen de portada del post.
     *
     * @return la URL de la imagen de portada del post
     */
    public String getUrlImagenPortada() {
        return urlImagenPortada;
    }

    /**
     * Establece la URL de la imagen de portada del post.
     *
     * @param urlImagenPortada la URL de la imagen de portada del post
     */
    public void setUrlImagenPortada(String urlImagenPortada) {
        this.urlImagenPortada = urlImagenPortada;
    }

    /**
     * Devuelve la URL de la imagen adicional del post.
     *
     * @return la URL de la imagen adicional del post
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen adicional del post.
     *
     * @param urlImagen la URL de la imagen adicional del post
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Devuelve si el post está fijado o no.
     *
     * @return true si el post está fijado, false si no lo está
     */
    public Boolean getFijado() {
        return fijado;
    }

    /**
     * Establece si el post debe estar fijado o no.
     *
     * @param fijado true para fijar el post, false para quitar el fijado
     */
    public void setFijado(Boolean fijado) {
        this.fijado = fijado;
    }

    /**
     * Devuelve el usuario que creó el post.
     *
     * @return el usuario que creó el post
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que creó el post.
     *
     * @param usuario el usuario que creó el post
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la lista de comentarios asociados al post.
     *
     * @return la lista de comentarios del post
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios asociados al post.
     *
     * @param comentarios la lista de comentarios del post
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Agrega un comentario a la lista de comentarios del post.
     *
     * @param comentario el comentario a agregar
     */
    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    /**
     * Elimina un comentario de la lista de comentarios del post.
     *
     * @param comentario el comentario a eliminar
     */
    public void removeComentario(Comentario comentario) {
        this.comentarios.remove(comentario);
    }

    /**
     * Cadena de texto de la instancia
     *
     * @return texto de los valores
     */
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + ", usuario=" + usuario + ", comentarios=" + comentarios + '}';
    }
}

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
 * Clase que representa un comentario hecho por un usuario en un post.
 *
 * @author USER
 */
@Entity
@Table(name = "Comentarios")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHora", nullable = false)
    private Date fechaHora;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comentario_padre_id")
    private Comentario comentarioPadre;

    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentariosHijos = new ArrayList<>();

    /**
     * Constructor por ausencia
     */
    public Comentario() {
    }

    /**
     * Constructor que crea un nuevo Comentario
     *
     * @param fechaHora la fecha y hora en la que se hizo el comentario
     * @param contenido el contenido del comentario
     * @param usuario el usuario que hizo el comentario
     * @param post el post al que pertenece el comentario
     */
    public Comentario(Date fechaHora, String contenido, Usuario usuario, Post post) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
    }

    /**
     * Constructor que crea un nuevo Comentario
     *
     * @param id el identificador único del comentario
     * @param fechaHora la fecha y hora en la que se creó el comentario
     * @param contenido el contenido del comentario
     * @param usuario el usuario que creó el comentario
     * @param post el post al que pertenece el comentario
     */
    public Comentario(Long id, Date fechaHora, String contenido, Usuario usuario, Post post) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
    }

    /**
     * Constructor que crea un nuevo Comentario
     *
     * @param fechaHora la fecha y hora en la que se creó el comentario
     * @param contenido el contenido del comentario
     * @param usuario el usuario que creó el comentario
     * @param post el post al que pertenece el comentario
     * @param comentarioPadre el comentario padre del comentario
     */
    public Comentario(Date fechaHora, String contenido, Usuario usuario, Post post, Comentario comentarioPadre) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
        this.comentarioPadre = comentarioPadre;
    }

    /**
     * Constructor que crea un nuevo Comentario
     *
     * @param id el identificador único del comentario
     * @param fechaHora la fecha y hora en la que se creó el comentario
     * @param contenido el contenido del comentario
     * @param usuario el usuario que creó el comentario
     * @param post el post al que pertenece el comentario
     * @param comentarioPadre el comentario padre del comentario
     */
    public Comentario(Long id, Date fechaHora, String contenido, Usuario usuario, Post post, Comentario comentarioPadre) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
        this.comentarioPadre = comentarioPadre;
    }

    /**
     * Devuelve el identificador único del comentario.
     *
     * @return el identificador único del comentario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del comentario.
     *
     * @param id identificador del comentario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha y hora en la que se creó el comentario.
     *
     * @return la fecha y hora en la que se creó el comentario
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora en la que se creó el comentario.
     *
     * @param fechaHora la fecha y hora en la que se creó el comentario
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Devuelve el contenido del comentario.
     *
     * @return el contenido del comentario
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido el contenido del comentario
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve el usuario que creó el comentario.
     *
     * @return el usuario que creó el comentario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Devuelve el post al que pertenece el comentario.
     *
     * @return el post al que pertenece el comentario
     */
    public Post getPost() {
        return post;
    }

    /**
     * Establece el post al que pertenece el comentario.
     *
     * @param post el post al que pertenece el comentario
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Establece el usuario que creó el comentario.
     *
     * @param usuario el usuario que creó el comentario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve el comentario padre del comentario.
     *
     * @return el comentario padre del comentario
     */
    public Comentario getComentarioPadre() {
        return comentarioPadre;
    }

    /**
     * Establece el comentario padre del comentario.
     *
     * @param comentarioPadre el comentario padre del comentario
     */
    public void setComentarioPadre(Comentario comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    /**
     * Devuelve la lista de comentarios hijos del comentario.
     *
     * @return la lista de comentarios hijos del comentario
     */
    public List<Comentario> getComentariosHijos() {
        return comentariosHijos;
    }

    /**
     * Establece la lista de comentarios hijos del comentario.
     *
     * @param comentariosHijos la lista de comentarios hijos del comentario
     */
    public void setComentariosHijos(List<Comentario> comentariosHijos) {
        this.comentariosHijos = comentariosHijos;
    }

    /**
     * Agrega un comentario hijo al comentario.
     *
     * @param comentarioHijo el comentario hijo a agregar
     */
    public void addComentarioHijo(Comentario comentarioHijo) {
        comentarioHijo.setComentarioPadre(this);
        this.comentariosHijos.add(comentarioHijo);
    }

    /**
     * Elimina un comentario hijo del comentario.
     *
     * @param comentarioHijo el comentario hijo a eliminar
     */
    public void removeComentarioHijo(Comentario comentarioHijo) {
        comentarioHijo.setComentarioPadre(null);
        this.comentariosHijos.remove(comentarioHijo);
    }
}

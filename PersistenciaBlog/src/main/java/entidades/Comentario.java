/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name="Comentarios")
public class Comentario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fechaHora",nullable = false)
    private Date fechaHora;
    
    @Column(name="contenido",nullable = false)
    private String contenido;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, Usuario usuario, Post post) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
    }

    public Comentario(Long id, Date fechaHora, String contenido, Usuario usuario, Post post) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuario=" + usuario + ", post=" + post + '}';
    }
    
    
    
    
}

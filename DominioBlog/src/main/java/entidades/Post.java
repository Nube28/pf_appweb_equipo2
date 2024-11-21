/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name="Posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fechaHoraCreacion",nullable = false)
    private Date fechaHoraCreacion;
    
    @Column(name="titulo",nullable = false)
    private String titulo;
    
    @Column(name="contenido",nullable = false)
    private String contenido;
    
    @Column(name="fechaHoraEdicion",nullable = true)
    private Date fechaHoraEdicion;
    
    @Column(name="urlImagenPortada",nullable = false)
    private String urlImagenPortada;
    
    @Column(name="urlImagen",nullable = true)
    private String urlImagen;
    
    @Column(name="fijado",nullable = false)
    private Boolean fijado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @OneToMany(mappedBy="post")
    private List<Comentario> comentarios;
    
    public Post() {
    }

    public Post(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String urlImagenPortada, String urlImagen, Boolean fijado) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.urlImagenPortada = urlImagenPortada;
        this.urlImagen = urlImagen;
        this.fijado = fijado;
    }

    public Post(Long id, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion, String urlImagenPortada, String urlImagen, Boolean fijado) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.urlImagenPortada = urlImagenPortada;
        this.urlImagen = urlImagen;
        this.fijado = fijado;
    }
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public String getUrlImagenPortada() {
        return urlImagenPortada;
    }

    public void setUrlImagenPortada(String urlImagenPortada) {
        this.urlImagenPortada = urlImagenPortada;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Boolean getFijado() {
        return fijado;
    }

    public void setFijado(Boolean fijado) {
        this.fijado = fijado;
    }

    
    
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + ", usuario=" + usuario + ", comentarios=" + comentarios + '}';
    }
    
    
    
}

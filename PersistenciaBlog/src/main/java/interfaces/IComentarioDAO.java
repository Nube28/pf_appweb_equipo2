/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Comentario;
import entidades.Post;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IComentarioDAO {
    
    public boolean hacerComentario(Comentario comentario) throws PersistenciaException;
    
    public boolean editarComentario(Comentario comentario) throws PersistenciaException;
    
    public boolean eliminarComentario(Comentario comentario) throws PersistenciaException;
    
    public List<Comentario> consultarComentariosDelPost(Post post) throws PersistenciaException;
    
    public List<Comentario> consultarComentariosHijosDelPost(Post post) throws PersistenciaException;
    
    public Comentario obtenerPorId(Long id) throws PersistenciaException;
}

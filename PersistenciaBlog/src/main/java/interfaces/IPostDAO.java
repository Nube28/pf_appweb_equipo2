/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPostDAO {
    
    public boolean hacerPost(Post post) throws PersistenciaException;
    
    public boolean editarPost(Post post) throws PersistenciaException;
    
    public boolean eliminarPost(Post post) throws PersistenciaException;
    
    public List<Post> consultarPostsDelUsuario(Usuario usuario) throws PersistenciaException;
    
    public List<Post> consultarPostMasRecientes()throws PersistenciaException;
    
    public Usuario consultarUsuarioPorPost(Post post) throws PersistenciaException;
    
    public Post consultarPostPorId(Long id) throws PersistenciaException;
    
}

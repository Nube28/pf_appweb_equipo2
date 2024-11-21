/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 *
 * @author USER
 */
public interface IUsuarioDAO {
    
    public boolean registrarUsuario(Usuario usuario) throws PersistenciaException;
    
    public boolean editarUsuario(Usuario usuario) throws PersistenciaException;
    
    public boolean eliminarUsuario(Usuario usuario) throws PersistenciaException;
    
    public Usuario encontrarUsuarioPorCorreoYContrasena(String correo, String contrasena) throws PersistenciaException;
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import conexionEM.Conexion;
import conexionEM.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    private final IConexion conexion;

    public UsuarioDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.persist(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al registrar el usuario", e);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean editarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.merge(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al editar el usuario", e);
        } finally {
            em.close();
        }

    }
    

    @Override
    public boolean eliminarUsuario(Usuario usuario) throws PersistenciaException {
                EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            em.remove(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new PersistenciaException("Error al eliminar el usuario", e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public Usuario encontrarUsuarioPorCorreoYContrasena(String correo, String contrasenia) throws PersistenciaException {
    EntityManager em = conexion.abrir();
    try {
        String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("correo", correo);
        query.setParameter("contrasenia", contrasenia);
        Usuario usuario = query.getResultList().stream().findFirst().orElse(null);

        return usuario;
    } catch (Exception e) {
        e.printStackTrace();
        throw new PersistenciaException("Error al encontrar el usuario por correo y contraseña", e);
    } finally {
        em.close();
    }
}

    
}

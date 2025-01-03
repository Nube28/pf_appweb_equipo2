package servlets;

import entidades.Usuario;
import excepciones.PersistenciaException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.UsuarioDAO;

/**
 *
 * @author Berry
 */
@WebServlet(name = "RegistrarUsuarioDatosUbicacion", urlPatterns = {"/RegistrarUsuarioDatosUbicacion"})
public class RegistrarUsuarioDatosUbicacion extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession();
            String estado = request.getParameter("estado");
            String municipio = request.getParameter("municipio");
            String ciudad = request.getParameter("ciudad");
            String nombre = (String) session.getAttribute("nombre");
            String apellidoPaterno = (String) session.getAttribute("apellidoPaterno");
            String apellidoMaterno = (String) session.getAttribute("apellidoMaterno");
            String email = (String) session.getAttribute("email");
            String contra = (String) session.getAttribute("contra");
            String telefono = (String) session.getAttribute("telefono");
            String fechaNacimientoStr = (String) session.getAttribute("fechaNacimiento");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); 
            String urlAvatar = (String) session.getAttribute("urlAvatar");
            Date fechaNacimiento;
            
            fechaNacimiento = formatoFecha.parse(fechaNacimientoStr);
            String genero = (String) session.getAttribute("genero");
            
            Usuario usuario = new Usuario(urlAvatar, nombre, apellidoPaterno, apellidoMaterno, email, contra, telefono, fechaNacimiento, genero, false);
            //usuario.setEstado(new Estado(estado, usuario));
            //usuario.setMunicipio(new Municipio(municipio, usuario));
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            usuarioDAO.registrarUsuario(usuario);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarUsuarioDatosUbicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarUsuarioDatosUbicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

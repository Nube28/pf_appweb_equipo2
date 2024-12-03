package servlets;

import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.UsuarioDAO;

/**
 *
 * @author USER
 */
public class IniciarSesion extends HttpServlet {

    
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
        String correo=request.getParameter("email");
        String contra=request.getParameter("contra");
        IUsuarioDAO usuarioDAO=new UsuarioDAO();
        
        try {

            Usuario usuario = usuarioDAO.encontrarUsuarioPorCorreoYContrasena(correo, contra);
            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", usuario.getId());
                session.setAttribute("usuarioLogueado", usuario);
                session.setAttribute("esAdmin", usuario.getTipo());
                response.sendRedirect("PaginaInicial");
            }else{
                request.setAttribute("errorMensaje", "No se encontró el usuario con esas características.");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
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

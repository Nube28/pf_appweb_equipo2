package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Berry
 */
@WebServlet(name = "RegistrarUsuarioDatosBasicos", urlPatterns = {"/RegistrarUsuarioDatosBasicos"})
public class RegistrarUsuarioDatosBasicos extends HttpServlet {

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
        HttpSession session = request.getSession();
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellido-paterno");
        String apellidoMaterno = request.getParameter("apellido-materno");
        String email = request.getParameter("email");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contra = request.getParameter("contra");
        String confirmacontra = request.getParameter("confirmar-contra");
        if (!confirmacontra.equalsIgnoreCase(contra)) {
            request.setAttribute("errorMensaje", "Las contraseñas no coinciden. Inténtalo de nuevo.");
            getServletContext().getRequestDispatcher("/registrarUsuarioDatosBasicos.jsp").forward(request, response);
        } else {
            session.setAttribute("nombre", nombre);
            session.setAttribute("apellidoPaterno", apellidoPaterno);
            session.setAttribute("apellidoMaterno", apellidoMaterno);
            session.setAttribute("email", email);
            session.setAttribute("nombreUsuario", nombreUsuario);
            session.setAttribute("contra", contra);
            getServletContext().getRequestDispatcher("/registrarUsuarioDatosPersonales.jsp").forward(request, response);
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

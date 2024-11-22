/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Berry
 */
@WebServlet(name = "RegistrarUsuarioDatosPersonales", urlPatterns = {"/RegistrarUsuarioDatosPersonales"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class RegistrarUsuarioDatosPersonales extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "img/uploads/avatars";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fecha-nacimiento");
        String genero = request.getParameter("genero");

        session.setAttribute("telefono", telefono);
        session.setAttribute("fechaNacimiento", fechaNacimiento);
        session.setAttribute("genero", genero);

        String uploadDir = "imgs/upload"; 
        String pathGuardar = request.getServletContext().getRealPath("/") + uploadDir;

        File dir = new File(pathGuardar);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        Part filePart = request.getPart("avatar"); 
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();


        InputStream fileContent = filePart.getInputStream();
        File targetFile = new File(pathGuardar, fileName);
        Files.copy(fileContent, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        fileContent.close();

        String urlAvatar = uploadDir + "/" + fileName;
        session.setAttribute("urlAvatar", urlAvatar);

        getServletContext().getRequestDispatcher("/registrarUsuarioDatosUbicacion.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

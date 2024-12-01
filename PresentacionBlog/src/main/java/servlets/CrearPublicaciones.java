/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entidades.Post;
import entidades.Usuario;
import excepciones.PersistenciaException;
import interfaces.IPostDAO;
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
import java.util.Date;
import persistencia.PostDAO;

/**
 *
 * @author Natasha Ruiz Perez
 */

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)

@WebServlet(name = "CrearPublicaciones", urlPatterns = {"/CrearPublicaciones"})
public class CrearPublicaciones extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "imgs/uploads/posts";

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
        
         response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    try {
        String uploadDir = request.getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String titulo = null;
        String descripcion = null;
        String portadaUrl = null;
        String imagenUrl = null;

        for (Part part : request.getParts()) {
            String name = part.getName();

            switch (name) {
                case "titulo":
                    titulo = new String(part.getInputStream().readAllBytes(), "UTF-8");
                    break;

                case "descripcion":
                    descripcion = new String(part.getInputStream().readAllBytes(), "UTF-8");
                    break;

                case "portada":
                    if (part.getSize() > 0) {
                        String portadaFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        File portadaFile = new File(uploadDir, portadaFileName);
                        try (InputStream input = part.getInputStream()) {
                            Files.copy(input, portadaFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                        portadaUrl = UPLOAD_DIRECTORY + "/" + portadaFileName;
                    }
                    break;

                case "imagen":
                    if (part.getSize() > 0) {
                        String imagenFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        File imagenFile = new File(uploadDir, imagenFileName);
                        try (InputStream input = part.getInputStream()) {
                            Files.copy(input, imagenFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                        imagenUrl = UPLOAD_DIRECTORY + "/" + imagenFileName;
                    }
                    break;

                default:
                    break;
            }
        }

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\": \"Usuario no autorizado.\"}");
            return;
        }

        // Crear y persistir publicación
        Post post = new Post(new Date(), titulo, descripcion, null, portadaUrl, imagenUrl, Boolean.FALSE, usuario);
        IPostDAO postDAO = new PostDAO();

        postDAO.hacerPost(post);

        // Respuesta exitosa
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(String.format("{\"id\": %d}", post.getId()));
    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("{\"error\": \"Error al procesar la solicitud.\"}");
    }
}
    
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        String titulo = request.getParameter("titulo");
//        String descripcion = request.getParameter("descripcion");
//
//        String uploadDir = request.getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
//        File dir = new File(uploadDir);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        String portadaUrl = null;
//        Part portadaPart = request.getPart("portada");
//        if (portadaPart != null && portadaPart.getSize() > 0) {
//            String portadaFileName = Paths.get(portadaPart.getSubmittedFileName()).getFileName().toString();
//            File portadaFile = new File(uploadDir, portadaFileName);
//            try (InputStream portadaContent = portadaPart.getInputStream()) {
//                Files.copy(portadaContent, portadaFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            }
//            portadaUrl = UPLOAD_DIRECTORY + "/" + portadaFileName;
//        }
//
//        String imagenUrl = null;
//        Part imagenPart = request.getPart("imagen");
//        if (imagenPart != null && imagenPart.getSize() > 0) {
//            String imagenFileName = Paths.get(imagenPart.getSubmittedFileName()).getFileName().toString();
//            File imagenFile = new File(uploadDir, imagenFileName);
//            try (InputStream imagenContent = imagenPart.getInputStream()) {
//                Files.copy(imagenContent, imagenFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            }
//            imagenUrl = UPLOAD_DIRECTORY + "/" + imagenFileName;
//        }
//        
//        HttpSession session = request.getSession();
//
//        Post post = new Post(new Date(), titulo, descripcion, null, portadaUrl, imagenUrl, Boolean.FALSE, (Usuario) session.getAttribute("usuarioLogueado"));
//        
//        IPostDAO postDAO = new PostDAO();
//        try {
//
//            postDAO.hacerPost(post);
//            response.setStatus(200);
//            response.getWriter().write(String.format("{\"id\": %d}", post.getId()));
//        } catch (PersistenciaException e) {
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write("{\"error\": \"Error al guardar la publicación.\"}");
//        }
//    }

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

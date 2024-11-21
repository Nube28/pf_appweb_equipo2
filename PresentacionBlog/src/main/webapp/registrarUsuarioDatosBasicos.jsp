<%-- 
    Document   : registrar-usuario-datos-basicos
    Created on : 20 nov 2024, 6:58:43 p.m.
    Author     : Berry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" href="styles/general.css" type="text/css">
        <link rel="stylesheet" href="styles/registro.css" type="text/css">
    </head>
    <body>
        <main> 
            <header>
                <h1 class="texto"> Registrar Usuario</h1>
            </header>
            
            <form action="RegistrarUsuarioDatosBasicos" method="POST">
                <fieldset>
                    <label for="nombre" class="texto">Nombre:</label>
                    <input type="text" name="nombre" class="escribir" required> 
                    <label for="apellido-paterno" class="texto">Apellido Paterno:</label>
                    <input type="text" name="apellido-paterno" class="escribir" required> 
                    <label for="apellido-materno" class="texto">Apellido Materno:</label>
                    <input type="text" name="apellido-materno" class="escribir" required> 
                    <label for="email" class="texto">Email:</label>
                    <input type="email" name="email" class="escribir" required
                    <label for="nombreUsuario" class="texto">Nombre de usuario:</label>
                    <input type="text" name="nombreUsuario" class="escribir" required>      
                    <label for="contra" class="texto">Contraseña:</label>
                    <input type="password" name="contra" class="escribir contraseña" required> 
                    <label for="confirmar-contra" class="texto">Confirmar contraseña:</label>
                    <input type="password" name="confirmar-contra" class="escribir contraseña" required>
                </fieldset>
                <%
                    String errorMensaje = (String) request.getAttribute("errorMensaje");
                    if (errorMensaje != null) {
                %>
                <div class="advertencia">
                    <p><%= errorMensaje%></p>
                </div>
                <%
                    }
                %>
                <footer>
                    <button type="submit" class="boton">Continuar</button>
                    <p class="texto">Si ya tienes una cuenta:</p>
                    <a href="index.jsp">Inicia Sesión</a>
                </footer>
            </form>
        </main>
    </body>
</html>

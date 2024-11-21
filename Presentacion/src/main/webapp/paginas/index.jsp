<%-- 
    Document   : index
    Created on : 20 nov 2024, 6:55:12 p.m.
    Author     : Berry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="..\styles\general.css" type="text/css">
    <link rel="stylesheet" href="..\styles\registro.css" type="text/css">
</head>
<body> 
    <main>
        <header>
            <h1 class="texto">Iniciar Sesión</h1>
        </header>
        <form action="pagina-inicial.html">
            <fieldset>
                <label for="email" class="texto">Email:</label>
                <input type="email" id="email" name="email" class="escribir">

                <label for="contra" class="texto">Contraseña:</label>
                <input type="password" id="contra" name="contra" class="escribir contraseña">
            </fieldset>
            <footer>
                <button type="submit" class="boton">Iniciar Sesión</button>
                <p class="texto">¿No tienes una cuenta?</p>
                <a href="registrar-usuario-datos-basicos.html">Regístrate</a>
            </footer>
        </form>
    </main>
</body>
</html>


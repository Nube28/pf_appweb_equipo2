<%-- 
    Document   : registrar-usuarios-datos-personales
    Created on : 20 nov 2024, 6:59:15 p.m.
    Author     : Berry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Usuario</title>
    <link rel="stylesheet" href="styles\general.css" type="text/css">
    <link rel="stylesheet" href="styles\registro.css" type="text/css">
</head>
<body>
    <main> 
        <header>
            <h1 class="texto"> Registrar Usuario</h1>
        </header>
        <form action="RegistrarUsuarioDatosPersonales" method="POST" enctype="multipart/form-data">
            <fieldset>
                <label for="telefono" class="texto">Telefono:</label>
                <input type="tel" name="telefono" class="escribir" required> 

                <label for="fecha-nacimiento" class="texto">Fecha nacimiento:</label>
                <input type="date" name="fecha-nacimiento" class="escribir fecha" required> 

                <label for="genero" class="texto">Genero:</label>
                <div>
                    <input type="radio" name="genero" value="hombre" class="radio-button" required> 
                    <label for="hombre" class="texto">Hombre</label>
                    <input type="radio" name="genero" value="mujer" class="radio-button" required> 
                    <label for="mujer" class="texto">Mujer</label>
                    <input type="radio" name="genero" value="otro" class="radio-button" required> 
                    <label for="otro" class="texto">Otro</label>
                </div>
                <label for="avatar" class="texto">Avatar:</label>
                <input type="file" name="avatar" class="escribir texto" accept="image/*" required>
            </fieldset>
            <footer>
                <a href="registrarUsuarioDatosBasicos.jsp"><button type="button" class="boton">Regresar</button></a>
                <button type="submit" class="boton">Continuar</button>
            </footer>
        </form>
    </main>
</body>
</html>

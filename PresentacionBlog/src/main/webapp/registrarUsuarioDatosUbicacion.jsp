<%-- 
    Document   : registrar-usuario-datos-ubicacion
    Created on : 20 nov 2024, 6:59:50 p.m.
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
        <form action="RegistrarUsuarioDatosUbicacion" method="POST">
            <fieldset>
                <label for="estado" class="texto">Estado:</label>
                <select id="estado" name="estado" class="escribir">
                    <option value="sonora" >Sonora</option>
                    <option value="baja-california">Baja California</option>
                    <option value="chihuahua">Chihuahua</option>
                </select>
                <label for="municipio" class="texto">Municipio:</label>
                <select id="municipio" name="municipio" class="escribir">
                    <option value="cajeme">Cajeme</option>
                    <option value="hermosillo">Hermosillo</option>
                    <option value="nogales">Nogales</option>
                </select>
                <label for="ciudad" class="texto" >Ciudad:</label>
                <select id="ciudad" name="ciudad" class="escribir">
                    <option value="ciudad-obregon">Ciudad Obregon</option>
                    <option value="baja-california">Esperanza</option>
                    <option value="chihuahua">Pueblo Yaqui</option>
                </select>
            </fieldset>
            <footer>
                <a href="registrarUsuarioDatosBasicos.jsp"><button type="button" class="boton">Regresar</button></a>
                <button type="submit" class="boton">Continuar</button>
            </footer>
        </form>
    </main>
</body>
</html>

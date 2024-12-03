<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Crear publicacion</title>
        <link rel="stylesheet" href="../styles/general.css" type="text/css" />
        <link rel="stylesheet" href="../styles/header.css" type="text/css" />
        <link rel="stylesheet" href="../styles/publicacion.css" type="text/css" />
    </head>

    <body>
        <header>
            <a href="../PaginaInicial" class="logo-container">
                <img src="../imgs/logo.png" alt="Logo" class="foto-logo" />
            </a>

            <div>
                <img src="../${usuarioLogueado.urlAvatar}" alt="Foto de Perfil" class="foto-perfil" />
                <p>${fn:escapeXml(usuarioLogueado.nombre)}</p>
            </div>
        </header>

        <main>
            <form id="form-publicacion" class="form-publicacion" enctype="multipart/form-data">
                <fieldset class="fiel-crear-container">
                    <input type="hidden" name="idUsuario" id="idUsuario" value="${(usuarioLogueado.id)}">
                    <div class="form-group">
                        <label for="titulo">Titulo: <span class="textitoDeAbajo">(Obligatorio)</span></label>
                        <input type="text" id="titulo" name="titulo" class="texto" />
                    </div>
                    <div class="form-group">
                        <label for="portada">Portada: <span class="textitoDeAbajo">(Obligatorio)</span> </label>
                        <input type="file" id="portada" name="portada" class="texto" accept="image/png, image/jpeg" />
                    </div>
                    <label for="descripcion">Contenido: <span class="textitoDeAbajo">(Obligatorio)</span></label>
                    <textarea id="descripcion" name="descripcion" class="textarea" class="texto"></textarea>
                    <div class="form-group">
                        <label for="imagen">Imagenes: <span class="textitoDeAbajo">(Opcional)</span></label>
                        <input type="file" id="imagen" name="imagen" class="texto" accept="image/jpg, image/jpeg, image/png" />
                    </div>
                    <button type="submit" class="boton">Publicar</button>
                </fieldset>
            </form>
        </main>
        <footer></footer>
    </main>
    <script src="../js/crearPublicacion.js" type="application/javascript"></script>
</body>
</html>

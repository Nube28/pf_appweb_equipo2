<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Crear publicacion</title>
  <link rel="stylesheet" href="styles/general.css" type="text/css" />
  <link rel="stylesheet" href="styles/header.css" type="text/css" />
  <link rel="stylesheet" href="styles/publicacion.css" type="text/css" />
</head>

<body>
  <%@ include file="/header.jspf" %>
  <main>
      <form id="form-publicacion" action="CrearPublicaciones" enctype="multipart/form-data" method="POST">
      <fieldset class="fiel-crear-container">
        <div class="form-group">
          <label for="titulo">Titulo: <span class="textitoDeAbajo">(Obligatorio)</span></label>
          <input type="text" id="titulo" name="titulo" class="texto" />
        </div>
        <div class="form-group">
          <label for="portada"> Portada:<span class="textitoDeAbajo">(Obligatorio)</span> </label>
          <input type="file" id="portada" name="portada" class="texto" />
        </div>
        <label for="descripcion">Contenido:<span class="textitoDeAbajo1">(Obligatorio)</span></label>
        <textarea id="descripcion" name="descripcion" class="textarea" class="texto"></textarea>
        <div class="form-group">
          <label for="imagen">Imagenes: <span class="textitoDeAbajo">(Opcional)</span></label>
          <input type="file" id="imagen" name="imagen" class="texto" />
        </div>
        <button type="submit" class="boton">Publicar</button>
      </fieldset>
    </form>
  </main>
  <footer></footer>
  </main>
</body>
</html>

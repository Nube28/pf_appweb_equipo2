<%-- 
    Document   : perfil
    Created on : 20 nov 2024, 6:57:10 p.m.
    Author     : Berry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Perfil Nombre</title>
  <link rel="stylesheet" href="..\styles\general.css" type="text/css" />
  <link rel="stylesheet" href="../styles/header.css" type="text/css" />
  <link rel="stylesheet" href="../styles/feed-principal.css" type="text/css" />
</head>

<body>
  <header>
    <a href="pagina-inicial.jsp" class="logo-container">
      <img src="../imgs/logo.png" alt="Logo" class="foto-logo" />
    </a>

    <a href="perfil.jsp" class="foto-perfil-container">
      <img src="../imgs/hardcodeadas/foto-perfil.jpg" alt="Foto de Perfil" class="foto-perfil" />
      <p>Gomez21345</p>
    </a>
  </header>
  <section class="foto-y-nombre-container">
    <img src="../imgs/hardcodeadas/foto-perfil.jpg" alt="Foto de perfil" class="foto-perfil-grande">
    <h1>
      Gomez21345
    </h1>
  </section>
  <main>
    <section class="publicaciones-container">
      <a href="ver-publicacion.jsp">
        <article class="publicacion">
          <img src="../imgs/hardcodeadas/sidon.jpg" alt="Imagen" class="portada-publicacion" />
          <h3>El gomez esta jugando otra vez al Zelda: Tears of the kingdom</h3>
          <p>Publicado por: Gomez21345</p> <br>
          <p>Publicado el: 10/10/2024 16:58</p>
          <p>Que juegazo que es y todo emulado!</p>
        </article>
      </a>
      <a href="ver-publicacion.jsp">
        <article class="publicacion">
          <img src="../imgs/hardcodeadas/sans.png" alt="Imagen" class="portada-publicacion" />
          <h3 class="undertale">SANS A SIDO AVISTADO USANDO COMIC SANS SIN PERMISO</h3>
          <p class="undertale">Publicado por: Gomez21345</p> <br>
          <p class="undertale">Publicado el: 05/10/2024 18:59</p>
          <p class="undertale">Sans el increible personaje de undertale aprueba este post</p>
        </article>
      </a>
    </section>
  </main>
</body>

</html>

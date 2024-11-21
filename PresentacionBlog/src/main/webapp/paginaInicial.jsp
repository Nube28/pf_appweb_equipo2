<%-- 
   Document   : pagina-inicial
   Created on : 20 nov 2024, 6:56:13 p.m.
   Author     : Berry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Pagina de Inicio</title>
        <link rel="stylesheet" href="styles\general.css" type="text/css" />
        <link rel="stylesheet" href="styles/header.css" type="text/css" />
        <link rel="stylesheet" href="styles\feed-principal.css" type="text/css" />
    </head>

    <body>
        <%@ include file="/header.jspf" %>
        <main>
            <section class="fijados-container">
                <a href="ver-publicacion-fijada.jsp">
                    <article class="publicacion-fijada">
                        <img src="../imgs/hardcodeadas/sidon.jpg" alt="Imagen" class="portada-publicacion" />
                        <h3>El gomez esta jugando otra vez al Zelda: Tears of the kingdom</h3>
                        <img src="../imgs/pin-fijado.png" alt="Pin de Fijado">
                        <p>Publicado por: Gomez21345</p> <br>
                        <p>Publicado el: 10/10/2024 16:58</p>
                        <p>Que juegazo que es y todo emulado!</p>
                    </article>
                </a>
                <a href="ver-publicacion-fijada.jsp">
                    <article class="publicacion-fijada">
                        <img src="../imgs/hardcodeadas/emily.jpg" alt="Imagen" class="portada-publicacion" />
                        <h3>El creador de stardew Valley esta haciendo Otro juego! que locura</h3>
                        <img src="../imgs/pin-fijado.png" alt="Pin de Fijado">
                        <p>Publicado por: xSpaceKat</p> <br>
                        <p>Publicado el: 02/10/2024 09:42</p>
                        <p>Puse a emily aun q no aparesca en el otro juego</p>
                    </article>
                </a>
            </section>
            <h2 class="subtitulo">
                Recientes
            </h2>
            <c:forEach var="post" items="${posts}">

                <section class="publicaciones-container">
                    <a href="VerPublicacion?id=${post.id}">
                        <article class="publicacion">
                            <img src=${post.urlImagenPortada} alt="Imagen" class="portada-publicacion" />
                            <h4>${post.titulo}</h4>
                            <p>Publicado por: Nath</p> <br>
                            <p>Publicado el: ${post.fechaHoraCreacion}</p>
                        </article>
                    </a>
                </section>
            </c:forEach>
        </main>
        <aside>
            <a href="crear-publicacion.jsp">
                <img src="../imgs/agregar_publicacion.png" alt="Agregar publicacion" height="200px"
                     class="boton-agregar-publicacion" />
            </a>
        </aside>
    </body>
</html>

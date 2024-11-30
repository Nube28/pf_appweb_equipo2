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
        <link rel="stylesheet" href="styles/general.css" type="text/css" />
        <link rel="stylesheet" href="styles/header.css" type="text/css" />
        <link rel="stylesheet" href="styles/feed-principal.css" type="text/css" />
    </head>
    <body>
        <%@ include file="/logueado/header.jspf" %>
        <main>
            <section class="publicaciones-container">
                <c:forEach var="post" items="${postsRecientesFijados}">
                    <a href="VerPublicacion?id=${post.id}">
                        <article class="publicacion-fijada">
                        <img src="${post.urlImagenPortada}" alt="Imagen" class="portada-publicacion" />
                        <h4>${post.titulo}</h4>
                        <p>Publicado por: ${post.usuario.nombre}</p> <br>
                        <p>Publicado el: ${post.fechaHoraCreacion}</p>
                        </article>
                    </a>
                </c:forEach>
            </section>
            <h2 class="subtitulo">
                Recientes
            </h2>
            <section class="publicaciones-container">
                <c:forEach var="post" items="${postsRecientes}">
                    <a href="VerPublicacion?id=${post.id}">
                        <article class="publicacion">
                            <img src=${post.urlImagenPortada} alt="Imagen" class="portada-publicacion" />
                            <h4>${post.titulo}</h4>
                            <p>Publicado por: ${post.usuario.nombre}</p> <br>
                            <p>Publicado el: ${post.fechaHoraCreacion}</p>
                        </article>
                    </a>
                </c:forEach>
            </section>
        </main>
        <aside>
            <c:choose>
                <c:when test="${!esAdmin}">
                    <a href="logueado/crearPublicacion.jsp">
                        <img src="imgs/agregar_publicacion.png" alt="Agregar publicacion" height="200px"
                             class="boton-agregar-publicacion" />
                    </a>
                </c:when>
            </c:choose>
        </aside>
        
    </body>
</html>

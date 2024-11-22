<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="styles/general.css" type="text/css" />
        <link rel="stylesheet" href="styles/header.css" type="text/css" />
        <link rel="stylesheet" href="styles/publicacion.css" type="text/css" />
        <title>${fn:escapeXml(post.titulo)}</title>
    </head>

    <body>
        <%@ include file="/header.jspf" %>
        <main>
            <section class="usuario-informacion">
                <div class="foto-y-nombre-container">
                    <img src="${fn:escapeXml(autor.urlAvatar)}" alt="Foto de Perfil del publicador"
                         class="foto-perfil-autor" />
                    <h3> ${fn:escapeXml(autor.nombre)} </h3>
                </div>
                <div class="informacion-publicacion">
                    <p>Publicado el ${fn:escapeXml(post.fechaHoraCreacion)}</p>
                    <p>Ultima edición: ${fn:escapeXml(post.fechaHoraEdicion)}</p>
                </div>
            </section>
            <section class="publicacion">
                <img src="${post.urlImagenPortada}" alt="Imagen portada" class="foto-portada" />
                <h2>${fn:escapeXml(post.titulo)}</h2>
                <p> ${fn:escapeXml(post.contenido)} </p>
                <c:if test="${not empty sessionScope.urlAvatar}">
                    <div class="imagenes-extra-container">
                        <img src="${post.urlImagen}" alt="Imagen extras" class="imagen-extra" />
                    </div>
                </c:if>
                <c:choose>
                    <c:when test="${esAdmin}">
                        <button type="submit" class="boton marg">Fijar</button>
                        <button type="submit" class="boton marg">Eliminar</button>
                    </c:when>
                </c:choose>
            </section>
        </main>
        <section class="section-comentarios">
            <form action="" id="comentar">
                <fieldset class="realizar-comentario">
                    <label for="comentario">Comentar:</label>
                    <input type="text" name="comentario" class="texto">
                    <button type="submit" class="boton">Comentar</button>
                </fieldset>
            </form>
            <section class="comentarios-contanier">
                <h3>Comentarios:</h3>
                <div class="comentario">
                    <img src="../imgs/hardcodeadas/foto-perfil.jpg" alt="Foto de Perfil" />
                    <h4>Gomez21345</h4>
                    <p>Wooow como me gusta este juego de verdad robaron ese titulo merecidicimo</p>
                    <p>Publicado el 16/10/2024 19:02</p>

                    <c:choose>
                        <c:when test="${!esAdmin}">
                            <a href="#comentar">Responder</a>
                        </c:when>
                    </c:choose>


                </div>
                <div class="comentario">
                    <img src="../imgs/hardcodeadas/joker.avif" alt="Foto de Perfil" />
                    <h4>xSpaceKat</h4>
                    <p>Pues a mi me gusta el Gow pero es que el Red dead Redemption 2 es una obra maestra!</p>
                    <p>Publicado el 15/10/2024 20:37</p>
                    <a href="#comentar">Responder</a>
                </div>
            </section>
        </section>
    </body>

</html>

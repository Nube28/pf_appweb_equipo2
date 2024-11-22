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
            <c:choose>
                <c:when test="${!esAdmin}">
                    <form action="" id="comentar">
                        <fieldset class="realizar-comentario">
                            <label for="comentario">Comentar:</label>
                            <input type="text" name="comentario" class="texto">
                            <button type="submit" class="boton">Comentar</button>
                        </fieldset>
                    </form>
                </c:when>
            </c:choose>
            <section class="comentarios-contanier">
                <h3>Comentarios:</h3>
                <c:forEach var="comentario" items="${comentarios}">
                    <div class="comentario">
                        <img src="${comentario.usuario.urlAvatar}" alt="Foto de Perfil" />
                        <h4>${fn:escapeXml(comentario.usuario.nombre)}</h4>
                        <p>${fn:escapeXml(comentario.contenido)}</p>
                        <p>Publicado el ${fn:escapeXml(comentario.fechaHora)}</p>

                        <c:choose>
                            <c:when test="${!esAdmin}">
                                <a href="#comentar">Responder</a>
                            </c:when>
                        </c:choose>
                    </div>
                </c:forEach>
            </section>
        </section>
    </body>

</html>

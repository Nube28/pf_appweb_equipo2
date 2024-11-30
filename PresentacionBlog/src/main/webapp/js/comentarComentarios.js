document.addEventListener("DOMContentLoaded", () => {
    const comentarioForms = document.querySelectorAll(".form-comentario-respuesta");

    comentarioForms.forEach((comentarioForm) => {
        comentarioForm.addEventListener("submit", async (event) => {
            event.preventDefault();

            const contenido = comentarioForm.querySelector(".texto").value;
            const usuarioId = document.getElementById("idUsuario").value;
            const postId = comentarioForm.querySelector("#idPost").value;
            const comentarioPadreId = comentarioForm.querySelector("#idComentario").value;

            try {
                const response = await fetch("http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/ComentarHijo", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        contenido,
                        usuarioId: parseInt(usuarioId, 10),
                        postId: parseInt(postId, 10),
                        comentarioPadreId: parseInt(comentarioPadreId, 10)
                    })
                });

                if (!response.ok) {
                    const errorData = await response.json();
                    alert(`Error: ${errorData.error}`);
                    return;
                }

                const comentario = await response.json();
                alert("Comentario agregado con éxito.");
                console.log(comentario);
            } catch (error) {
                console.error("Error al enviar la solicitud:", error);
                alert("Ocurrió un error al intentar agregar el comentario.");
            }
        });
    });
});







////document.addEventListener("DOMContentLoaded", () => {
//    const comentarioForm = document.getElementById("form-comentario-respuesta");
//
//    comentarioForm.addEventListener("submit", async (event) => {
//        event.preventDefault();
//
//        const contenido = document.getElementById("contenido").value;
//        const usuarioId = document.getElementById("usuarioId").value;
//        const postId = document.getElementById("idPost").value;
//        const comentarioPadreId = document.getElementById("idComentario").value;
//
//        try {
//            const response = await fetch("http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/ComentarComentario", {
//                method: "POST",
//                headers: {
//                    "Content-Type": "application/json",
//                },
//                body: JSON.stringify({
//                    contenido: contenido,
//                    usuarioId: parseInt(usuarioId, 10),
//                    postId: parseInt(postId, 10),
//                    comentarioPadreId: parseInt(comentarioPadreId, 10),
//                }),
//            });
//
//            if (!response.ok) {
//                const errorData = await response.json();
//                alert(`Error: ${errorData.error}`);
//                return;
//            }
//
//            const comentario = await response.json();
//            alert("Comentario agregado con éxito.");
//            console.log(comentario);
//
//        } catch (error) {
//            console.error("Error al enviar la solicitud:", error);
//            alert("Ocurrió un error al intentar agregar el comentario.");
//        }
//    });
//});



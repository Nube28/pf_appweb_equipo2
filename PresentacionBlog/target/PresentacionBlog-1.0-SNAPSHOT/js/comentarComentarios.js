document.addEventListener("DOMContentLoaded", () => {
    const comentarioForms = document.querySelectorAll(".form-comentario-respuesta");

    comentarioForms.forEach((comentarioForm) => {
        comentarioForm.addEventListener("submit", async (event) => {
            event.preventDefault();

            const contenido = comentarioForm.querySelector(".texto").value;
            const usuarioId = document.getElementById("idUsuario").value;
            const postId = comentarioForm.querySelector("#idPost").value;
            const comentarioPadreId = comentarioForm.querySelector("#idComentario").value;

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
                throw new Error(`Error en la respuesta del servidor: ${response.status}`);
            }
            
            window.location.reload();
            
            const comentario = await response.json();
            alert("Comentario agregado con éxito.");
            console.log(comentario);
            
            
        });
    });
});
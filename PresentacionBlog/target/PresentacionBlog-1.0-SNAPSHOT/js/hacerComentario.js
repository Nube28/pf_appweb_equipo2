document.addEventListener("DOMContentLoaded", () => {
    const comentarioForms = document.querySelectorAll(".form-comentario");
    
    comentarioForms.forEach((comentarioForm) => {
        comentarioForm.addEventListener("submit", async (event) => {
            event.preventDefault();
            
            const contenido = comentarioForm.querySelector(".texto").value;
            const usuarioId = comentarioForm.querySelector("#idUsuario").value; 
            const postId = comentarioForm.querySelector("#idPost").value;
            
            
            const response = await fetch("http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/HacerComentarios", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    contenido,
                    usuarioId: parseInt(usuarioId, 10),
                    postId: parseInt(postId, 10)
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



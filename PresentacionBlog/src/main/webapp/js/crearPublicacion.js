document.addEventListener("DOMContentLoaded", () => {
    const crearPublicacionForms = document.querySelectorAll(".form-publicacion");

    crearPublicacionForms.forEach((crearPublicacionForm) => {
        crearPublicacionForm.addEventListener("submit", async (event) => {
            event.preventDefault();

            const formData = new FormData(crearPublicacionForm);

            try {
                const response = await fetch("http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/CrearPublicaciones", {
                    method: "POST",
                    body: formData
                });

                if (!response.ok) {
                    throw new Error(`Error en la respuesta del servidor: ${response.status}`);
                }

                const result = await response.json();
                alert("Publicación creada con éxito.");
                console.log(result);
                window.location.reload();
            } catch (error) {
                console.error("Error al crear la publicación:", error);
                alert("Hubo un error al crear la publicación.");
            }
        });
    });
});



//document.addEventListener("DOMContentLoaded", () => {
//    const crearPublicacionForms = document.querySelectorAll(".form-publicacion");
//
//    crearPublicacionForms.forEach((crearPublicacionForm) => {
//        crearPublicacionForm.addEventListener("submit", async (event) => {
//            event.preventDefault();
//
//            const titulo = crearPublicacionForm.getElementById("#titulo").value;
//            const portada = crearPublicacionForm.getElementById("#portada").value;
//            const usuarioId = crearPublicacionForm.getElementById("#idUsuario").value;
//            const contenido = crearPublicacionForm.getElementById("#descripcion").value;
//            const imagen = crearPublicacionForm.getElementById("#imagen").value;
//
//            const response = await fetch("http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/CrearPublicaciones", {
//                method: "POST",
//                headers: {
//                    "Content-Type": "application/json"
//                },
//                body: JSON.stringify({
//                    titulo,
//                    portada,
//                    usuarioId: parseInt(usuarioId, 10),
//                    contenido,
//                    imagen
//                })
//            });
//
//            if (!response.ok) {
//                throw new Error(`Error en la respuesta del servidor: ${response.status}`);
//            }
//            
//            window.location.reload();
//            
//            const comentario = await response.json();
//            alert("Comentario agregado con éxito.");
//            console.log(comentario);
//        });
//    });
//});


//document.getElementById('form-publicacion').addEventListener('submit', async function (event) {
//    event.preventDefault(); 
//    const formData = new FormData(this);
//
//    const response = await fetch('../CrearPublicaciones', {
//        method: 'POST',
//        body: formData
//    }).then(result => {
//        if (result.ok) {
//            return result.json();
//        } else {
//            throw new Error("Error en el response");
//        }
//    }).then(json => {
//        const id = json.id;
//        window.location.href = `../VerPublicacion?id=${id}`;
//    }).catch(error => {
//        console.error(`Error de conexión: ${error.message}`);
//    });
//});
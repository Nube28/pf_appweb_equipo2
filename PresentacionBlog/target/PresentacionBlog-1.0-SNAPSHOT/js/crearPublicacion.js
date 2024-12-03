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
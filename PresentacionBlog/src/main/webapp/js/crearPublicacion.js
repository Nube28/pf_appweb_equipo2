document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form-publicacion");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const formData = new FormData(form);
        const responseMessage = document.getElementById("response-message");

        try {
            const response = await fetch("/CrearPublicacion", {
                method: "POST",
                body: formData
            });

            if (response.ok) {
                const result = await response.json();
                // Redirigir al usuario a la página específica de la publicación
                window.location.href = `/publicacion?id=${result.id}`;
            } else {
                const error = await response.text();
                responseMessage.textContent = `Error al crear la publicación: ${error}`;
                responseMessage.style.color = "red";
            }
        } catch (error) {
            responseMessage.textContent = `Error de conexión: ${error.message}`;
            responseMessage.style.color = "red";
        }
    });
});


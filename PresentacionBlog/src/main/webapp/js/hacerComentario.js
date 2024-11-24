document.getElementById('form-comentario').addEventListener('submit', async function (event) {
    event.preventDefault(); 
    const formData = new FormData(this);

    const response = await fetch('../HacerComentarios', {
        method: 'POST',
        body: formData
    }).then(result => {
        if (result.ok) {
            return result.json();
        } else {
            throw new Error("Error en el response");
        }
    }).then(json => {
        const id = json.id;
        window.location.href = `../VerPublicacion?id=${id}`;
    }).catch(error => {
        console.error(`Error de conexión: ${error.message}`);
    });
});


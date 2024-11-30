document.getElementById('form-comentario').addEventListener('submit', async function (event) {
    event.preventDefault();
    const formData = new FormData(this);

    try {
        const response = await fetch('http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/HacerComentarios', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            const json = await response.json();
            const id = json.id;
            window.location.href = `http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/VerPublicacion?id=${id}`;
        } else {
            const error = await response.json();
            console.error(`Error del servidor: ${error.error}`);
        }
    } catch (error) {
        console.error(`Error de conexión: ${error.message}`);
    }
});

////document.getElementById('form-comentario').addEventListener('submit', async function (event) {
//    event.preventDefault(); 
//    const formData = new FormData(this);
//
//    const response = await fetch('http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/HacerComentarios', {
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
//        window.location.href = `http://localhost:8080/PresentacionBlog-1.0-SNAPSHOT/VerPublicacion?id=${id}`;
//    }).catch(error => {
//        console.error(`Error de conexión: ${error.message}`);
//    });
//});


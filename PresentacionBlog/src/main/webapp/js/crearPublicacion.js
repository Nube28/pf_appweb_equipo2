document.getElementById('form-publicacion').addEventListener('submit', async function (event) {
    event.preventDefault(); 
    console.log("")
    const formData = new FormData(this);
    
 
        const response = await fetch('../CrearPublicaciones', {
            method: 'POST',
            body: formData
        }).then(result =>{
            if (result.ok){
              return result.json();  
            }else{
                throw new Error("Mensajito erro ahi no se");
            }
        }).then(json =>{
            const id=json.id;
            window.location.href=`../VerPublicacion?id=${id}`;
        }).catch(error=>{
            console.error(`Error de conexión: ${error.message}`);
        });
});
////document.addEventListener("DOMContentLoaded", () => {
//    const form = document.getElementById("form-publicacion");
//
//    form.addEventListener("submit", async (event) => {
//        event.preventDefault();
//
//        
//        const responseMessage = document.getElementById("response-message");
//
//        try {
//            const response = await fetch("/CrearPublicacion", {
//                method: "POST",
//                body: formData
//            });
//
//            
//        } catch (error) {
//            responseMessage.textContent = `Error de conexión: ${error.message}`;
//            responseMessage.style.color = "red";
//        }
//    });
//});





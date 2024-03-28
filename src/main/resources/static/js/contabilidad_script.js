const cardContabilidad = document.getElementById("generarFactura");
const generarFacturaModal = document.getElementById("generarFacturaModal");
const generarFacturaForm = document.getElementById("generarFacturaForm");
const hiddenItem = document.getElementById("mensajeOculto");

cardContabilidad.addEventListener("click", abrirModal);

function abrirModal(){
	generarFacturaModal.style.display = "block";
}

function cerrarModal() {
//	setTimeout(function() {
//		generarFacturaModal.style.display = "none";
//        generarFacturaForm.reset();
//		fetch('/contabilidad', {
//	        method: 'GET'
//	    })
//    }, 1000);

	console.log("ITEM: "+hiddenItem.value);
}

function cancelarModal() {
	generarFacturaModal.style.display = "none";
	generarFacturaForm.reset();
}
const cardGenerarFactura = document.getElementById("generarFactura");
const generarFacturaModal = document.getElementById("generarFacturaModal");
const generarFacturaForm = document.getElementById("generarFacturaForm");

const cardGenerarEgreso = document.getElementById("generarEgreso");
const generarEgresoModal = document.getElementById("generarEgresoModal");
const generarEgresoForm = document.getElementById("generarEgresoForm");
const hiddenItem = document.getElementById("mensajeOculto");

cardGenerarFactura.addEventListener("click", abrirModalFactura);
cardGenerarEgreso.addEventListener("click", abrirModalEgreso);

function abrirModalFactura(){
	generarFacturaModal.style.display = "block";
}

function cerrarModalFactura() {
//	setTimeout(function() {
//		generarFacturaModal.style.display = "none";
//        generarFacturaForm.reset();
//		fetch('/contabilidad', {
//	        method: 'GET'
//	    })
//    }, 1000);

	console.log("ITEM: "+hiddenItem.value);
}

function cancelarModalFactura() {
	generarFacturaModal.style.display = "none";
	generarFacturaForm.reset();
}








function abrirModalEgreso(){
	generarEgresoModal.style.display = "block";
}

function cerrarModalEgreso() {
//	setTimeout(function() {
//		generarFacturaModal.style.display = "none";
//        generarFacturaForm.reset();
//		fetch('/contabilidad', {
//	        method: 'GET'
//	    })
//    }, 1000);

	console.log("ITEM: "+hiddenItem.value);
}

function cancelarModalEgreso() {
	generarEgresoModal.style.display = "none";
	generarEgresoForm.reset();
}
const cardGenerarFactura = document.getElementById("generarFactura");
const generarFacturaModal = document.getElementById("generarFacturaModal");
const generarFacturaForm = document.getElementById("generarFacturaForm");

const cardGenerarEgreso = document.getElementById("generarEgreso");
const generarEgresoModal = document.getElementById("generarEgresoModal");
const generarEgresoForm = document.getElementById("generarEgresoForm");

cardGenerarFactura.addEventListener("click", abrirModalFactura);
cardGenerarEgreso.addEventListener("click", abrirModalEgreso);

function abrirModalFactura(){
	generarFacturaModal.style.display = "block";
}

function cancelarModalFactura(){
	generarFacturaModal.style.display = "none";
	generarFacturaForm.reset();
}

function abrirModalEgreso(){
	generarEgresoModal.style.display = "block";
}

function cancelarModalEgreso(){
	generarEgresoModal.style.display = "none";
	generarEgresoForm.reset();
}
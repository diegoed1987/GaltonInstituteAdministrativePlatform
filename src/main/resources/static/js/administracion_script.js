const cardButton = document.getElementById("cardCreateUser");
const crearUsuarioForm = document.getElementById("crearUsuarioForm");
const closeUsuarioModalBtn = document.getElementById("closeUsuarioModal");

cardButton.addEventListener("click", abrirModal);
closeUsuarioModalBtn.addEventListener("click",cerrarModal);


var modal = document.getElementById("administrarUsuarioModal");

function abrirModal() {
	modal.style.display = "block";
}

function cerrarModal() {
	modal.style.display = "none";
	crearUsuarioForm.reset();
}

function limpiarFormModalUsuario(){
	crearUsuarioForm.reset();
}


function crearUsuario() {
    var form = document.getElementById("create-user-form");
    var formData = new FormData(form);

    fetch('/crearUsuario', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        Swal.fire({
            icon: data.icon,
            title: data.title,
            text: data.text,
            allowOutsideClick: false
        }).then(() => {
            if (data.icon === 'success') {
                window.location.href = '/administracion';
            }
        });
    })
}

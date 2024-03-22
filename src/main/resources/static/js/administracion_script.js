const cardButton = document.getElementById("cardCreateUser");

cardButton.addEventListener("click",abrirModal);


var modal = document.getElementById("administrarUsuarioModal");

function abrirModal() {
	modal.style.display = "block";
}

function cerrarModal() {
	modal.style.display = "none";
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

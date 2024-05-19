const cardButton = document.getElementById("cardCreateUser");
const crearUsuarioForm = document.getElementById("crearUsuarioForm");
const closeUsuarioModalBtn = document.getElementById("closeUsuarioModal");
const spinner = document.getElementById("spinnerContainer");

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

var modalActualizarUsuario = document.getElementById("actualizaUsuarioModal");
var actualizaUsuarioForm = document.getElementById("actualizaUsuarioForm1");

function abrirActualizarModal(){
	modalActualizarUsuario.style.display = "grid";
}

function cerrarActualizarModal(){
	modalActualizarUsuario.style.display = "none";
	actualizaUsuarioForm.reset();
}

//function cargarUsuario(id){
//	console.log("ID: "+id);
//	fetch('/usuario/'+id)
//	.then(response => response.json())
//    .then(data => {
//        document.getElementById('emailUsuario').value = data.emailUsuario;
//        abrirActualizarModal();
//    })
//}

function cargarInformacionUsuario(id){
	spinner.style.display = "flex";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var usuario = JSON.parse(xhr.responseText);
                document.getElementById("actualizaIdUsuario").value = usuario.idUsuario;
                document.getElementById("actualizaDocumentoUsuario").value = usuario.documentoUsuario;
                document.getElementById("actualizaNombreUsuario").value = usuario.nombreUsuario;
                document.getElementById("actualizaEmailUsuario").value = usuario.emailUsuario;
                document.getElementById("actualizaPasswordUsuario").value = usuario.passwordUsuario;
                document.getElementById("actualizaFechaNacimiento").value = usuario.fechaNacimiento;
                document.getElementById("actualizaRolUsuario").value = usuario.rolUsuario;
                document.getElementById("actualizaEstadoUsuario").value = usuario.estadoUsuario;
                document.getElementById("actualizaSedeUsuario").value = usuario.sedeUsuario;
                document.getElementById("actualizaDireccionUsuario").value = usuario.direccionUsuario;
                document.getElementById("actualizaTelefonoUsuario").value = usuario.telefonoUsuario;
                spinner.style.display = "none";
                abrirActualizarModal();
            } else {
                alert('Error al cargar los detalles del usuario');
            }
        }
	};
	xhr.open("GET", "usuario/"+id, true);
	xhr.send();
}

//function actualizarUsuario2() {
//	
//	var form = document.getElementById("actualizaUsuarioForm1");
//	var formData = new FormData(form);
//	
//	var xhr = new XMLHttpRequest();
//    xhr.open("POST", "usuario/modificarUsuario2", true);
//    //xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//    xhr.setRequestHeader("Content-Type", "application/json");
//    
//    var dataForm = {
//		idUsuario: formData.get("idUsuario"),
//        documentoUsuario: formData.get("documentoUsuario"),
//        nombreUsuario: formData.get("nombreUsuario"),
//        emailUsuario: formData.get("emailUsuario"),
//        passwordUsuario: formData.get("passwordUsuario"),
//        fechaNacimiento: formData.get("fechaNacimiento"),
//        rolUsuario: formData.get("rolUsuario"),
//        estadoUsuario: formData.get("estadoUsuario"),
//        sedeUsuario: formData.get("sedeUsuario"),
//        direccionUsuario: formData.get("direccionUsuario"),
//        telefonoUsuario: formData.get("telefonoUsuario")
//	};
//
//    xhr.onload = function() {
//        if (xhr.status === 200) {
//            refreshUserTable();
//            cerrarActualizarModal();
//        } else {
//            console.error("ERRORRRRRRR: "+xhr.responseText);
//        }
//    };
//
//    xhr.send(JSON.stringify(dataForm));
//
//}

//function refreshUserTable() {
//    var xhr = new XMLHttpRequest();
//    xhr.open("GET", "usuario/cargarListaUsuarios", true);
//
//    xhr.onload = function() {
//        if (xhr.status === 200) {
//            document.getElementById("tablaListaUsuarios").innerHTML = xhr.responseText;
//            cerrarActualizarModal();
//        } else {
//            console.error(xhr.responseText);
//        }
//    };
//
//    xhr.send();
//}


document.addEventListener("DOMContentLoaded", function() {
  var input = document.getElementById("searchUsuario");
  input.addEventListener("keyup", function() {
    var value = this.value.trim().toLowerCase();
    var rows = document.querySelectorAll("#tablaListaUsuario tr");
    rows.forEach(function(row) {
      var text = row.textContent.trim().toLowerCase();
      if (text.includes(value)) {
        row.style.display = "table-row";
      } else {
        row.style.display = "none";
      }
    });
  });
});

/*CARGAR SELECT ITEMS CREAR SEDE*/

const cardOpcionesSede = document.getElementById("cardOpcionesSede");
cardOpcionesSede.addEventListener("click",cargarDepartamentos);
const modalOpcionesSede = document.getElementById("administrarSedeModal");
const crearSedeForm = document.getElementById("crearSedeForm");
const closeSedeModalBtn = document.getElementById("closeSedeModal");
closeSedeModalBtn.addEventListener("click",cerrarModalOpcionSede);

const selectDepartamento = document.getElementById('departamentoSede');
selectDepartamento.addEventListener("change",cargarMunicipios);
const selectMunicipio = document.getElementById('municipioSede');

function abrirModalOpcionesSede(){
	modalOpcionesSede.style.display = "block";
}

function cerrarModalOpcionSede(){
	modalOpcionesSede.style.display = "none";
	crearSedeForm.reset();
	selectMunicipio.disabled = true;
}

function limpiarFormModalSede(){
	crearSedeForm.reset();
	selectMunicipio.disabled = true;
}

function cargarDepartamentos(){
	spinner.style.display = "flex";
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var departamentos = JSON.parse(xhr.responseText);
                var select = document.getElementById('departamentoSede'); 
                departamentos.forEach(function(departamento) {
                    var option = document.createElement('option');
                    option.value = departamento.codigoDepartamento;
                    option.text = departamento.nombreDepartamento;
                    select.appendChild(option);
                });
                selectMunicipio.disabled = true;
                spinner.style.display = "none";
                abrirModalOpcionesSede();
            } else {
                alert('Error al cargar los departamentos');
            }
        }
    };
    xhr.open('GET', 'sede/listaDepartamentos', true);
    xhr.send();
}

function cargarMunicipios(){

	var idDepartamento = selectDepartamento.value;
	
	if(idDepartamento > 0){
		
		selectMunicipio.innerHTML = '<option value="">Seleccione...</option>';
	
		var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === XMLHttpRequest.DONE) {
	            if (xhr.status === 200) {
	                var municipios = JSON.parse(xhr.responseText);
	                var select = document.getElementById('municipioSede'); 
	                municipios.forEach(function(municipio) {
	                    var option = document.createElement('option');
	                    option.value = municipio.codigoMunicipio;
	                    option.text = municipio.nombreMunicipio;
	                    select.appendChild(option);
	                });
	                selectMunicipio.disabled = false;
	            } else {
	                alert('Error al cargar los municipios');
	            }
	        }
	    };
	    xhr.open('GET', 'sede/listaMunicipios/'+idDepartamento, true);
	    xhr.send();
	}else{
		selectMunicipio.innerHTML = '<option value="">Seleccione...</option>';
		selectMunicipio.disabled = true;
	}

}

/*MODAL ACTUALIZAR SEDE*/

const actualizaSedeModal = document.getElementById("actualizaSedeModal");
const actualizaSedeForm = document.getElementById("actualizaSedeForm1");

function abrirActualizarSedeModal(){
	actualizaSedeModal.style.display = "grid";
}

function cerrarActualizarSedeModal(){
	actualizaSedeModal.style.display = "none";
	actualizaSedeForm.reset();
}

function cargarInformacionSede(codigoSede){
	
	//document.getElementById("spinnerSedeContainer").style.display = "flex";
	//document.getElementById("spinnerSede").style.display = "block";
	spinner.style.display = "flex";
	
	var idSede = codigoSede.replace(/"/g, '');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var sede = JSON.parse(xhr.responseText);
                
                cargarDepartamentosActualizar();
                cargarMunicipiosActualizar(sede.departamentoSede);
                
                setTimeout(() => {
				    
	                document.getElementById("actualizarCodigoSede").value = sede.codigoSede;
	                document.getElementById("actualizarNombreSede").value = sede.nombreSede;
	                document.getElementById("actualizarDireccionSede").value = sede.direccionSede;
	                document.getElementById("actualizarDepartamentoSede").value = sede.departamentoSede;
	                document.getElementById("actualizarMunicipioSede").value = sede.municipioSede;
	                document.getElementById("actualizarTelefonoSede").value = sede.telefonoSede;
	                
	                //document.getElementById("spinnerSedeContainer").style.display = "none";
	                //document.getElementById("spinnerSede").style.display = "none";
	                spinner.style.display = "none";
	                abrirActualizarSedeModal();
				}, 1000);
                
            } else {
                alert('Error al cargar los detalles del usuario');
            }
        }
	};
	xhr.open("GET", "sede/cargarInformacionSede/"+idSede, true);
	xhr.send();
}

/*CARGAR SELECT ITEMS ACTUALIZAR SEDE*/

function cargarDepartamentosActualizar(){
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var departamentos = JSON.parse(xhr.responseText);
                var select = document.getElementById('actualizarDepartamentoSede'); 
                departamentos.forEach(function(departamento) {
                    var option = document.createElement('option');
                    option.value = departamento.codigoDepartamento;
                    option.text = departamento.nombreDepartamento;
                    select.appendChild(option);
                });
                abrirModalOpcionesSede();
            } else {
                alert('Error al cargar los departamentos');
            }
        }
    };
    xhr.open('GET', 'sede/listaDepartamentos', true);
    xhr.send();
}

document.getElementById('actualizarDepartamentoSede').addEventListener("change",cargarMunicipiosActualizar);

function cargarMunicipiosActualizar(codDepartamento){

	var idDepartamento;
	var select = document.getElementById('actualizarMunicipioSede');
	
	if(document.getElementById('actualizarDepartamentoSede').value > 0){
		idDepartamento = document.getElementById('actualizarDepartamentoSede').value;
		select.innerHTML = '<option value="">Seleccione...</option>';
	}else{
		idDepartamento = codDepartamento;
	}

	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var municipios = JSON.parse(xhr.responseText);
                municipios.forEach(function(municipio) {
                    var option = document.createElement('option');
                    option.value = municipio.codigoMunicipio;
                    option.text = municipio.nombreMunicipio;
                    select.appendChild(option);
                });
            } else {
                alert('Error al cargar los municipios');
            }
        }
    };
    xhr.open('GET', 'sede/listaMunicipios/'+idDepartamento, true);
    xhr.send();
}

document.addEventListener("DOMContentLoaded", function() {
  var input = document.getElementById("searchSede");
  input.addEventListener("keyup", function() {
    var value = this.value.trim().toLowerCase();
    var rows = document.querySelectorAll("#tablaListaSedes tr");
    rows.forEach(function(row) {
      var text = row.textContent.trim().toLowerCase();
      if (text.includes(value)) {
        row.style.display = "table-row";
      } else {
        row.style.display = "none";
      }
    });
  });
});

/*---------- MODAL PROGRAMAS ---------------------*/

const cardModalPrograma = document.getElementById("cardOpcionesProgramas");
const modalPrograma = document.getElementById("administrarProgramaModal");
const cerrarProgramaModal = document.getElementById("closeProgramaModal");
const crearProgramaForm = document.getElementById("crearProgramaForm");

cardModalPrograma.addEventListener("click",abrirModalOpcionesPrograma);
cerrarProgramaModal.addEventListener("click",cerrarModalOpcionesPrograma);

function abrirModalOpcionesPrograma(){
	modalPrograma.style.display = "block";
}

function cerrarModalOpcionesPrograma(){
	modalPrograma.style.display = "none";
	crearProgramaForm.reset();
}

function limpiarFormularioPrograma(){
	crearProgramaForm.reset();
}

document.addEventListener("DOMContentLoaded", function() {
  var input = document.getElementById("searchPrograma");
  input.addEventListener("keyup", function() {
    var value = this.value.trim().toLowerCase();
    var rows = document.querySelectorAll("#tablaListaProgramas tr");
    rows.forEach(function(row) {
      var text = row.textContent.trim().toLowerCase();
      if (text.includes(value)) {
        row.style.display = "table-row";
      } else {
        row.style.display = "none";
      }
    });
  });
});

/*---------- MODAL EDITAR PROGRAMAS ---------------------*/

const abrirModificarProgramaModal = document.getElementById("actualizaProgramaModal");
const editarProgramaForm = document.getElementById("actualizaProgramaForm1");

function cargarInformacionPrograma(codigoPrograma){
	spinner.style.display = "flex";
	
	var idProgramaSelected = codigoPrograma.replace(/"/g, '');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var programa = JSON.parse(xhr.responseText);
                
				document.getElementById("actualizarIdPrograma").value = programa.idPrograma;
                document.getElementById("actualizarNombrePrograma").value = programa.nombrePrograma;
                document.getElementById("actualizarNombreCortoPrograma").value = programa.nombreCortoPrograma;
                document.getElementById("actualizarEstadoPrograma").value = programa.estadoPrograma;
                
                spinner.style.display = "none";
                abrirEditarProgramaModal();
                
            } else {
                alert('Error al cargar los detalles del Programa');
            }
        }
	};
	xhr.open("GET", "programa/cargarInformacionPrograma/"+idProgramaSelected, true);
	xhr.send();
}

function abrirEditarProgramaModal(){
	abrirModificarProgramaModal.style.display = "grid"
}

function cerrarEditarProgramaModal(){
	abrirModificarProgramaModal.style.display = "none"
	editarProgramaForm.reset();
}

/*---------- MODAL BANCOS ---------------------*/

const cardModalBanco = document.getElementById("cardOpcionesBancos");
const modalBanco = document.getElementById("administrarBancoModal");
const cerrarBancoModal = document.getElementById("closeBancoModal");
const crearBancoForm = document.getElementById("crearBancoForm");

cardModalBanco.addEventListener("click",abrirModalOpcionesBanco);
cerrarBancoModal.addEventListener("click",cerrarModalOpcionesBanco);

function abrirModalOpcionesBanco(){
	modalBanco.style.display = "block";
}

function cerrarModalOpcionesBanco(){
	modalBanco.style.display = "none";
	crearBancoForm.reset();
}

function limpiarFormularioBanco(){
	crearBancoForm.reset();
}

document.addEventListener("DOMContentLoaded", function() {
  var input = document.getElementById("searchBanco");
  input.addEventListener("keyup", function() {
    var value = this.value.trim().toLowerCase();
    var rows = document.querySelectorAll("#tablaListaBancos tr");
    rows.forEach(function(row) {
      var text = row.textContent.trim().toLowerCase();
      if (text.includes(value)) {
        row.style.display = "table-row";
      } else {
        row.style.display = "none";
      }
    });
  });
});


/*---------- MODAL EDITAR BANCOS ---------------------*/

const abrirModificarBancoModal = document.getElementById("actualizaBancoModal");
const editarBancoForm = document.getElementById("actualizaBancoForm1");

function cargarInformacionBanco(codigoBanco){
	spinner.style.display = "flex";
	
	var idBancoSelected = codigoBanco.replace(/"/g, '');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var banco = JSON.parse(xhr.responseText);
                
				document.getElementById("actualizarIdBanco").value = banco.idBanco;
                document.getElementById("actualizarNombreBanco").value = banco.nombreBanco;
                document.getElementById("actualizarEstadoBanco").value = banco.estadoBanco;
                
                spinner.style.display = "none";
                abrirEditarBancoModal();
                
            } else {
                alert('Error al cargar los detalles del Banco');
            }
        }
	};
	xhr.open("GET", "banco/cargarInformacionBanco/"+idBancoSelected, true);
	xhr.send();
}

function abrirEditarBancoModal(){
	abrirModificarBancoModal.style.display = "grid"
}

function cerrarEditarBancoModal(){
	abrirModificarBancoModal.style.display = "none"
	editarBancoForm.reset();
}
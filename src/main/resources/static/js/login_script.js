
/*------------- GIRAR TARJETA ------------*/
const front = document.getElementById('front-card')
const back = document.getElementById('back-card')
const btn = document.getElementById('flip-link')
const btn2 = document.getElementById('back-link')

function handleFlip() {
  front.classList.toggle('flipped')
  back.classList.toggle('flipped')
  document.getElementById("registrationForm").reset();
  document.getElementById("login-form").reset();
  {enableRegisterButton()}
  {enableLoginButton()}
}

btn.addEventListener('click', handleFlip)
btn2.addEventListener('click', handleFlip)


function registerUser() {
    var form = document.getElementById("registrationForm");
    var formData = new FormData(form);
    
    var message = document.getElementById("registrationMessage").value;

    fetch('/login', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        // Display success or error message using SweetAlert
        Swal.fire({
            icon: data.icon,
            title: data.title,
            text: data.text
        }).then(() => {
            // Redirect to login page if registration successful
            if (data.icon === 'success') {
                window.location.href = '/login';
            }
        });
    })
}

const registerBtn = document.getElementById("register-btn");
const documento = document.getElementById("documento");
const nombre = document.getElementById("nombre");
const email = document.getElementById("email");
const password = document.getElementById("password");
registerBtn.disabled = true;

function enableRegisterButton(){
	
	if (documento.value != '' && nombre.value != '' && email.value != '' && password.value != ''){
		registerBtn.disabled = false;
	}else{
		registerBtn.disabled = true;
	}
}

documento.onchange = function() {enableRegisterButton()};
nombre.onchange = function() {enableRegisterButton()};
email.onchange = function() {enableRegisterButton()};
password.onchange = function() {enableRegisterButton()};

const usuario = document.getElementById("usuario");
const loginPass = document.getElementById("login-password");
const loginBtn = document.getElementById("login-btn");
loginBtn.disabled = true;

function enableLoginButton(){
	
	if (usuario.value != '' && loginPass.value != ''){
		loginBtn.disabled = false;
	}else{
		loginBtn.disabled = true;
	}
}

usuario.onchange = function() {enableLoginButton()};
loginPass.onchange = function() {enableLoginButton()};




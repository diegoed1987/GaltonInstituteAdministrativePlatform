/*------------- GIRAR TARJETA ------------*/
const front = document.getElementById('front-card')
const back = document.getElementById('back-card')
const btn = document.getElementById('flip-link')
const btn2 = document.getElementById('back-link')

function handleFlip() {
  front.classList.toggle('flipped')
  back.classList.toggle('flipped')
}

btn.addEventListener('click', handleFlip)
btn2.addEventListener('click', handleFlip)


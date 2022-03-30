// Modal Inserción Tarjetas
const modalIngTar = document.getElementById("ingTarjModal");

const btnModIngTar = document.getElementById("btnModIngTarjeta");

const spanIngCli = document.getElementById("closeIngTarjModal");

btnModIngTar.onclick = function() {
    modalIngTar.style.display = "block";
}

spanIngCli.onclick = function() {
    modalIngTar.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalIngTar) {
        modalIngTar.style.display = "none";
    }
}


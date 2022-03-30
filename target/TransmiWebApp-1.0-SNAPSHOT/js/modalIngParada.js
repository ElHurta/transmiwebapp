// Modal Ingreso Paradas
const modalIngCli = document.getElementById("ingParadaModal");

const btnModIngCli = document.getElementById("btnModIngParada");

const spanIngCli = document.getElementById("closeIngParadaModal");

btnModIngCli.onclick = function() {
    modalIngCli.style.display = "block";
}

spanIngCli.onclick = function() {
    modalIngCli.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalIngCli) {
        modalIngCli.style.display = "none";
    }
}
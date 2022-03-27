// Modal Ingreso Clientes
const modalIngCli = document.getElementById("ingClientModal");

const btnModIngCli = document.getElementById("btnModIngCliente");

const span = document.getElementById("closeIngClientModal");

btnModIngCli.onclick = function() {
    modalIngCli.style.display = "block";
}

span.onclick = function() {
    modalIngCli.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalIngCli) {
        modalIngCli.style.display = "none";
    }
}


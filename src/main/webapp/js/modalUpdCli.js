// Modal Actualización Clientes
const modalActCli = document.getElementById("actClientModal");

const btnModActCli = document.getElementsByClassName("btnModActCliente");

const spanActCli = document.getElementById("closeActClientModal");

for (let i = 0; i < btnModActCli.length; i++) {
    btnModActCli[i].onclick = function () {
        modalActCli.style.display = "block";
        let clientId = btnModActCli[i].closest("tr").cells[0].textContent;

        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                if(this.responseText!=='null'){
                    let clienteObt = JSON.parse(this.responseText);
                    document.getElementById("client_id_upd").value = clienteObt.idCliente;
                    document.getElementById("new_client_id_upd").value = clienteObt.idCliente;
                    document.getElementById("client_nom_upd").value = clienteObt.nCliente;
                    document.getElementById("client_apel_upd").value = clienteObt.apelCliente;
                } else {
                    document.getElementById("client_id_upd").value = "";
                    document.getElementById("new_client_id_upd").value = "";
                    document.getElementById("client_nom_upd").value = "";
                    document.getElementById("client_apel_upd").value = "";
                }

            }
        };
        xhttp.open("GET", "http://localhost:8080/clientsServlet?clientId="+clientId, true);
        xhttp.send();

    }
}

spanActCli.onclick = function() {
    modalActCli.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalActCli) {
        modalActCli.style.display = "none";
    }
}

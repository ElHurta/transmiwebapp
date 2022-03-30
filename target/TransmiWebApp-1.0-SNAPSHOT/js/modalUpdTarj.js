// Modal Actualización Tarjetas
const modalActTar = document.getElementById("actTarjModal");

const btnModActTar = document.getElementsByClassName("btnModActTarj");

const spanActTar = document.getElementById("closeActTarjModal");

let addedValue;

for (let i = 0; i < btnModActTar.length; i++) {
    btnModActTar[i].onclick = function () {
        modalActTar.style.display = "block";
        let tarjetaId = btnModActTar[i].closest("tr").cells[0].textContent;

        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                if(this.responseText!=='null'){
                    let tarjetaObt = JSON.parse(this.responseText);
                    document.getElementById("tarjeta_id_upd").value = tarjetaObt.idTarjeta;
                    document.getElementById("tarjeta_sald_upd").value = tarjetaObt.saldoTarjeta;
                    document.getElementById("tarjeta_est_upd").value = tarjetaObt.estTarjeta;

                    let option = document.createElement("option");
                    option.value = tarjetaObt.cliente.idCliente;
                    option.innerHTML = tarjetaObt.cliente.idCliente + " - " + tarjetaObt.cliente.nCliente + " " + tarjetaObt.cliente.apelCliente;
                    option.selected = true;

                    addedValue = option.value;
                    document.getElementById("tarjeta_cli_upd").appendChild(option);

                } else {

                }
            }
        };
        xhttp.open("GET", "http://localhost:8080/tarjetaServlet?tarjetaId="+tarjetaId, true);
        xhttp.send();
    }
}

spanActTar.onclick = function() {
    modalActTar.style.display = "none";
    let selectUp = document.getElementById("tarjeta_cli_upd");

    if(selectUp.options[selectUp.options.length-1].value===addedValue){
        selectUp.options.remove(selectUp.options.length-1);
    }
}

window.onclick = function(event) {
    if (event.target === modalActTar) {
        modalActTar.style.display = "none";
        let selectUp = document.getElementById("tarjeta_cli_upd");

        if(selectUp.options[selectUp.options.length-1].value===addedValue){
            selectUp.options.remove(selectUp.options.length-1);
        }
    }
}

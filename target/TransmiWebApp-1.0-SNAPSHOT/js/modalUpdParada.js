// Modal Actualización Paradas
const modalActPar = document.getElementById("actParadaModal");

const btnModActPar = document.getElementsByClassName("btnModActParada");

const spanActPar = document.getElementById("closeActParadaModal");

for (let i = 0; i < btnModActPar.length; i++) {
    btnModActPar[i].onclick = function () {
        modalActPar.style.display = "block";
        let paradaId = btnModActPar[i].closest("tr").cells[0].textContent;

        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                if(this.responseText!=='null'){
                    let paradaObt = JSON.parse(this.responseText);
                    document.getElementById("parada_nom_upd").value = paradaObt.nParada;
                    document.getElementById("parada_type_upd").value = paradaObt.tipoParada;
                    document.getElementById("parada_id_upd").value = paradaId;
                } else {
                    document.getElementById("parada_nom_upd").value = "";
                    document.getElementById("parada_type_upd").value = "";
                    document.getElementById("parada_id_upd").value = "";
                }
            }
        };
        xhttp.open("GET", "http://localhost:8080/paradasServlet?paradaId="+paradaId, true);
        xhttp.send();
    }
}

spanActPar.onclick = function() {
    modalActPar.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalActPar) {
        modalActPar.style.display = "none";
    }
}

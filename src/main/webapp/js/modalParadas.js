// Modal Consulta de Paradas según rutas
const modalShowPar = document.getElementById("showParadasModal");

const btnModActCli = document.getElementsByClassName("btnModShowParadas");

const spanModShow = document.getElementById("closeShowParadas");

const paradasTitle = document.getElementById("paradas_title");

for (let i = 0; i < btnModActCli.length; i++) {
    btnModActCli[i].onclick = function () {
        modalShowPar.style.display = "block";
        let rutaId = btnModActCli[i].closest("tr").cells[0].textContent;

        const xhttp = new XMLHttpRequest();
        const table = document.getElementById("testBody");
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                if(this.responseText!=='[]'){
                    let rutaParada = JSON.parse(this.responseText);
                    rutaParada.forEach( item => {
                        let row = table.insertRow();
                        let rutaInfo = row.insertCell(0);
                        rutaInfo.innerHTML = item.ruta.idRuta + " - " + item.ruta.nRuta;
                        let paradaInfo = row.insertCell(1);
                        paradaInfo.innerHTML = item.parada.idParada + " - " + item.parada.nParada;
                    });
                } else {
                    while(table.hasChildNodes())
                    {
                        table.removeChild(table.firstChild);
                    }
                }
            }
        };
        xhttp.open("GET", "http://localhost:8080/rutasServlet?paradasBy="+rutaId, true);
        xhttp.send();
    }
}

spanModShow.onclick = function() {
    modalShowPar.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalShowPar) {
        modalShowPar.style.display = "none";
    }
}

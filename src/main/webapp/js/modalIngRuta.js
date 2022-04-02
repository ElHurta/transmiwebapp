// Modal Ingreso Rutas
const modalIngRut = document.getElementById("ingRutaModal");

const btnModIngRut = document.getElementById("btnModIngRuta");

const spanIngRut = document.getElementById("closeIngRutaModal");

let addParadaBtn = document.getElementById("addParadaToList");
let draggableList = document.getElementById("draggCont");
let paradasSelector = document.getElementById("paradasSelector");

btnModIngRut.onclick = function() {
    modalIngRut.style.display = "block";

    const xhttp = new XMLHttpRequest();
    const table = document.getElementById("testBody");
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            if(this.responseText!=='[]'){
                let allParadas = JSON.parse(this.responseText);
                console.log(allParadas);

                allParadas.forEach( item => {
                    let option = document.createElement("option");
                    option.value = item.idParada;
                    option.innerHTML = item.nParada + " - " + item.tipoParada;

                    paradasSelector.appendChild(option);
                });

            } else {
                while(table.hasChildNodes())
                {
                    table.removeChild(table.firstChild);
                }
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/paradasServlet?allParadas=true", true);
    xhttp.send();
}

spanIngRut.onclick = function() {
    modalIngRut.style.display = "none";
}

window.onclick = function(event) {
    if (event.target === modalIngRut) {
        modalIngRut.style.display = "none";
    }
}

addParadaBtn.onclick = function (){
    let paradaContainer = document.createElement("div");
    let paradaAdded = document.createElement("p");
    let paradaClose = document.createElement("span");

    let paradasIds = document.getElementById("ruta_paradas_ids_ins");

    paradaClose.innerHTML="&times;";

    const opt = paradasSelector.options[paradasSelector.selectedIndex];
    paradaAdded.id = opt.value;
    paradaAdded.innerHTML = opt.text;

    paradasSelector.options.remove(opt.index);

    paradaClose.onclick = function (){
        let optionReturn = document.createElement("option");
        optionReturn.value = paradaAdded.id;
        optionReturn.innerHTML = paradaAdded.textContent;
        paradasSelector.appendChild(optionReturn);
        draggableList.removeChild(paradaContainer);

        paradasIds.value= paradasIds.value.replace(","+paradaAdded.id, "");
        paradasIds.value= paradasIds.value.replace(paradaAdded.id+",", "")
        paradasIds.value= paradasIds.value.replace(paradaAdded.id+"", "")
    }

    paradaContainer.appendChild(paradaAdded);
    paradaContainer.appendChild(paradaClose);

    draggableList.appendChild(paradaContainer);
    if(paradasIds.value===""){
        paradasIds.value += paradaAdded.id;
    } else {
        paradasIds.value += ","+paradaAdded.id;
    }

}
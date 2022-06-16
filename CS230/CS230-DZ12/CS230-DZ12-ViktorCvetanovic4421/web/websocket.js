window.onload = init;
var socket = new WebSocket("ws://localhost:8080/WebsocketHome/actions");
socket.onmessage = onMessage;

function onMessage(event) {
    var osoba = JSON.parse(event.data);
    if (osoba.action === "add") {
        printDeviceElement(osoba);
    }
    if (osoba.action === "remove") {
        document.getElementById(osoba.id).remove();
    }
}

function addOsoba(name, prezime, indeks, nacinStudiranja) {
    var OsobaAction = {
        action: "add",
        name: name,
        prezime: prezime,
        indeks: indeks,
        nacinStudiranja: nacinStudiranja
    };
    socket.send(JSON.stringify(OsobaAction));
}

function removeOsoba(element) {
    var id = element;
    var OsobaAction = {
        action: "remove",
        id: id
    };
    socket.send(JSON.stringify(OsobaAction));
}

function printOsobaElement(osoba) {
    var content = document.getElementById("content");

    var osobaName = document.createElement("span");
    osobaName.setAttribute("class", "osoba_ime");
    osobaName.innerHTML = osoba.ime;
    osobaDiv.appendChild(osobaName);

    var osobaSurname = document.createElement("span");
    osobaSurname.setAttribute("class", "osoba_prezime");
    osobaSurname.innerHTML = osoba.prezime;
    osobaDiv.appendChild(osobaSurname);

    var osobaType = document.createElement("span");
    osobaType.innerHTML = "<b>Nacin studiranja:</b> " + osoba.nacinStudiranja;
    osobaDiv.appendChild(osobaType);


    var osobaIndeks = document.createElement("span");
    osobaIndeks.innerHTML = "<b>Indeks:</b> " + osoba.indeks;
    osobaDiv.appendChild(osobaIndeks);

    var removeOsoba = document.createElement("span");
    removeOsoba.setAttribute("class", "removeOsoba");
    removeOsoba.innerHTML = "<a href=\"#\" OnClick=removeDevice(" + osoba.id + ")>Remove osoba</a>";
    osobaDiv.appendChild(removeOsoba);
}

function showForm() {
    document.getElementById("addOsobaForm").style.display = '';
}

function hideForm() {
    document.getElementById("addOsobaForm").style.display = "none";
}

function formSubmit() {
    var form = document.getElementById("addOsobaForm");
    var name = form.elements["osoba_ime"].value;
    var surname = form.elements["osoba_prezime"].value;
    var indeks = form.elements["osoba_indeks"].value;
    var type = form.elements["osoba_nacinStudiranja"].value;
    hideForm();
    document.getElementById("addOsobaForm").reset();
    addOsoba(name, surname, indeks, type);
}

function init() {
    hideForm();
}

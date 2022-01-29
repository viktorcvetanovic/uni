var button = document.querySelector(".hamburgerButton");
var div = document.querySelector(".hamburgerBar");

function createNav() {
    div.innerHTML = `<div class="dimScreen">
  <ul class="Navnavigation ">

  <li class="nav-item active">
    <a class="nav-link secondNav" href="index.html">Pocetna</a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="oKompaniji.html">O kompaniji </a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="proizvodi.html">Proizvodi </a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="zaposleni.html">O nama </a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="karijere.html">Karijere</a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="kontakt.html">Kontakt </a>
  </li>

  <li class="nav-item active">
      <a class="nav-link secondNav" href="demo.html">Demo </a>
  </li>
</ul>
  
<button type="button" class="close" aria-label="Close" onclick="deleteNav();">
  <span aria-hidden="true" class="closeSpan">&times;</span>
</button>
  </div>`

}

function deleteNav() {
    div.innerHTML = "";
}

function clicked(number) {
    return fillDiv(number);
}


const objCar = {
    "fh16": ["Volvo FH16", "prizvodi_photos/linked/img.png"],
    "fh": ["Volvo FH", "prizvodi_photos/linked/img_1.png"],
    "fmx": ["Volvo FMX", "prizvodi_photos/linked/img_2.png"],
    "fm": ["Volvo FM", "prizvodi_photos/linked/img_3.png"],
    "fe": ["Volvo FE", "prizvodi_photos/linked/img_4.png"],
    "fl": ["Volvo FL", "prizvodi_photos/linked/img_5.png"]
}

function fillDiv(number) {
    document.querySelector(".borderShow").classList.add("bckColor");
    document.querySelector(".borderShow").innerHTML =
        `<img src=${objCar[number][1]} class="animation">
  <h2 class="positionH2">${objCar[number][0]} </h2><hr>
  <p style="max-width:50vw;">Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis. Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.<p>
  <buton class="btn btn-light buyButton" style="min-width:12vw;"><a href="demo.html">Naruci dostavu ovim kamionom</a></button>
 
  `
}

function showWorkers() {

    document.querySelector(".allWorkers").innerHTML = `<table class="table table-dark">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Ime</th>
        <th scope="col">Prezime</th>
        <th scope="col">Pozicija</th>
        <th scope="col">Vise informacija</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th scope="row" ">1</th>
        <td>David</td>
        <td>Stevanovic</td>
        <td>Sef</td>
        <td><button class="btn btn-light " onclick="tableShow(1)">+</button></td>
      </tr>
      <tr>
        <th scope="row">2</th>
        <td>Milan</td>
        <td>Milanovic</td>
        <td>Menadzer</td>
        <td><button class="btn btn-light" onclick="tableShow(2)">+</button></td>
      </tr>
      <tr>
        <th scope="row">3</th>
        <td>Petar</td>
        <td>Petrovic</td>
        <td>Dizajner</td>
        <td><button class="btn btn-light" onclick="tableShow(3)">+</button></td>
      </tr>
      <tr>
      <th scope="row">4</th>
      <td>Nikola</td>
      <td>Petrovic</td>
      <td>Dizajner</td>
      <td><button class="btn btn-light" onclick="tableShow(4)">+</button></td>
    </tr>
    <tr>
    <th scope="row">5</th>
    <td>Dejan</td>
    <td>Milovanovic</td>
    <td>Programer</td>
    <td><button class="btn btn-light " onclick="tableShow(5)">+</button></td>
  </tr>
    </tbody>
  </table>`
}

const allWorkers = ["David Stevanovic", "Milan Milanovic", "Petar Petrovic", "Nikola Petrovic", "Dejan Milovanovic"]

function tableShow(number) {
    switch (number) {
        case 1:
            oneWorker("David Stevanovic");
            break;
        case 2:
            oneWorker("Milan Milanovic");
            break;
        case 3:
            oneWorker("Petar Petrovic");
            break;
        case 4:
            oneWorker("Nikola Petrovic");
            break;
        case 5:
            oneWorker("Dejan Milovanovic");
            break;
        default:
            oneWorker("Ne postoji taj radnik")
    }
}

function searchForWorker() {
    var a = 0;
    var worker = document.querySelector(".searchWorkers").value;
    for (let i = 0; i < allWorkers.length; i++) {
        if (allWorkers[i] === worker) {
            oneWorker(worker);
            a = 1;
        }
    }
    if (a === 0) {
        alert("Ne postoji takav radnik")
    }
}

function oneWorker(name) {
    document.querySelector(".allWorkers").innerHTML = `
  <b><p style="font-size:20px">Ime ovog radnika je ${name}<p></b>
  <p style="max-width:50vw;">Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis. Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.<p>
  `
}

function showAllJobs() {
    document.querySelector(".addJob").innerHTML = `<div class="showJobs">
    <h3> Ovo su trenutni poslovi</h3> 
    <div style="margin-top:3rem">
    <img src="zaposleni_photos/jobPhoto.png">
    <h5>Automehanicar </h5>
    <p style="max-width:40vw"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu lacus vitae orci tempus placerat. In at leo sit amet elit scelerisque bibendum ut non nibh. Suspendisse interdum, urna at ullamcorper rhoncus, quam urna eleifend elit, eu lobortis libero quam at odio</p>

    <img src="zaposleni_photos/jobPhoto.png">
    <h5>It menadzer </h5>
    <p style="max-width:40vw"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu lacus vitae orci tempus placerat. In at leo sit amet elit scelerisque bibendum ut non nibh. Suspendisse interdum, urna at ullamcorper rhoncus, quam urna eleifend elit, eu lobortis libero quam at odio</p>

    <img src="zaposleni_photos/jobPhoto.png">
    <h5>Marketing </h5>
    <p style="max-width:40vw"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu lacus vitae orci tempus placerat. In at leo sit amet elit scelerisque bibendum ut non nibh. Suspendisse interdum, urna at ullamcorper rhoncus, quam urna eleifend elit, eu lobortis libero quam at odio</p>

    <div class="input-group" style="max-width:50vw !important">
    <div class="input-group-prepend">
      <span class="input-group-text" id="">First and last name</span>
    </div>
    <input type="text" class="form-control employee1">
    <input type="text" class="form-control employee2">
  
  </div></br>
  <input type="file" ><br><br>
  <button class="btn btn-light" onclick="getEmployeeInput()"> Posalji</button>
    </div>`
    document.querySelector(".afterJobDiv").innerHTML = `  <h2 class="h2align" style="margin-top: 5rem;">Vas DSD-Transport</h1>
    </br>

    `
}

function getEmployeeInput() {
    const array = [];
    var first = document.querySelector(".employee1").value;
    var second = document.querySelector(".employee2").value;
    if (first.length > 3 && second.length > 5) {
        alert("Uspesno ste poslali CV")
        array.push(first);
        array.push(second);
    } else {
        alert("Uneli ste pogresne podatke")
    }
}


function getListInput() {
    var array = document.getElementById("my-form").elements;
    if (array[0].value.includes(" ") || hasNumbers(array[0].value) || array[1].value.includes(" ") || hasNumbers(array[1].value)) {
        alert("Ime i prezime moraju biti jedna rec i bez razmaka")
    } else if (array[3].value.length > 200 || array[3].value.length < 10) {
        alert("Min unos je 10 reci, a max unos je 200 reci")
    }else {
        alert("Uspesno uneto")
    }


}

function addMap() {
    mapboxgl.accessToken = 'pk.eyJ1IjoidmlrdG9yY3ZldGFub3ZpYyIsImEiOiJja2oyNDM2c3A1MHNjMnFsYnZodmx1Mmh6In0.HcWpNazoTdm1XK690ZVErQ';
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11'
    });
}

function hasNumbers(t) {
    var regex = /\d/g;
    return regex.test(t);
}

function showPrice() {
    var element = document.querySelectorAll(".selectModel");
    var packet = 0;
    var preuzimanje = 0;
    var cenaTezine = 0;
    var cena = 0;
    if (element[2].value === "FULL") {
        packet = 5000;
    } else {
        packet = 2000;
    }
    if (element[3].value === "DOSTAVA") {
        preuzimanje = 1000;
    } else {
        preuzimanje = 2000;
    }

    switch (element[0].value) {
        case "FH16":
            cena = 4000;
            break;
        case "FH":
            cena = 6000;
            break;
        case "FMX":
            cena = 7000;
            break;
        case "FM":
            cena = 10000;
            break;
        case "FE":
            cena = 12000;
            break;
        case "FL":
            cena = 22000;
            break;
    }
    switch (element[1].value) {
        case ">1":
            cenaTezine = 1000;
            break
        case ">2":
            cenaTezine = 2000;
            break;
        case ">4":
            cenaTezine = 3500;
            break;
        case ">8":
            cenaTezine = 6500;
            break;
    }

    createPrice(Math.round(cena + preuzimanje + packet + cenaTezine));
}

function createPrice(price) {
    document.querySelector(".prikazCene").innerHTML = `<h2 class="h2align"> Cena dostave je </h2>
  <p>${price}$ </p>
  `
}

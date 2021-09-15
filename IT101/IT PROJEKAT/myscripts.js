var button=document.querySelector(".hamburgerButton");
var div=document.querySelector(".hamburgerBar");

function createNav(){
  div.innerHTML=`<div class="dimScreen">
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

function deleteNav(){
    div.innerHTML="";
}

function clicked(number) {
  switch(number){
    case "a4":
      return fillDiv("a4");
    case "a6":
      return fillDiv("a6");
      case "r8":
        return fillDiv("r8");
        case "a7":
          return fillDiv("a7");
          case "tt":
            return fillDiv("tt");
            case "a8":
              return fillDiv("a8");
              default:
                console.log("nema taj auto")

  }
 }

 
 const objCar={
  "a4":["Audi A4","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/55350-banner-318890-image/dh-1920-918e09/da0935cc/1602487748/1920x600-aa4-l-191004-3-v2-oe.jpg"],
  "a6":["Audi A6","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/48124-banner-259834-image/dh-1920-918e09/9091f5f7/1602489817/audi-galerie-6-oe.jpg"],
  "r8":["Audi R8","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/51838-banner-290650-image/dh-1920-918e09/0b5ca581/1602487519/1920x600-7-oe.jpg"],
  "a7":["Audi A7","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/45971-banner-243697-image/dh-1920-918e09/13b9fe53/1602487531/audi-galerie-5-oe.jpg"],
  "tt":["Audi TT","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/13782-banner-56215-image/dh-1920-918e09/a190c4ff/1602487488/1920x1080_0047_ATT_151004_oe.jpg"],
  "a8":["Audi A8","https://cdn-rs.audi.at/media/Theme_Banners_Banner_Image_Component/44960-banner-234781-image/dh-1920-918e09/38387bbf/1602486621/1920x1080-inlinemediagallery-aa8-171002-oe.jpg"]
}

function fillDiv(number){
  document.querySelector(".borderShow").classList.add("bckColor");
  document.querySelector(".borderShow").innerHTML=
  `<img src=${objCar[number][1]} class="animation">
  <h2 class="positionH2">${objCar[number][0]} </h2><hr>
  <p style="max-width:50vw;">Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis. Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.<p>
  <buton class="btn btn-light buyButton" style="min-width:12vw;">Kupi</button>
 
  `
}

function showWorkers(){
  
  document.querySelector(".allWorkers").innerHTML=`<table class="table table-dark">
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
        <td>Viktor</td>
        <td>Cvetanovic</td>
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
const allWorkers=["Viktor Cvetanovic","Milan Milanovic","Petar Petrovic","Nikola Petrovic","Dejan Milovanovic"]

function tableShow(number){
  switch(number){
    case 1:
      oneWorker("Viktor Cvetanovic");
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

function searchForWorker(){
  var a=0;
  var worker=  document.querySelector(".searchWorkers").value;
  for(let i=0;i<allWorkers.length;i++){
    if(allWorkers[i]===worker){
      oneWorker(worker);
      a=1;
    }
  }
  if(a==0){
    alert("Ne postoji takav radnik")
  }
}

function oneWorker(name){
  document.querySelector(".allWorkers").innerHTML=`
  <b><p style="font-size:20px">Ime ovog radnika je ${name}<p></b>
  <p style="max-width:50vw;">Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis. Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.Praesent fringilla ipsum et massa vulputate, eu rutrum tortor scelerisque. Praesent lobortis ligula at imperdiet iaculis. Sed rutrum dui id velit posuere sagittis.<p>
  `
}

function showAllJobs(){
    document.querySelector(".addJob").innerHTML =`<div class="showJobs">
    <h3> Ovo su trenutni poslovi</h3> 
    <div style="margin-top:3rem">
    <img src="jobPhoto.png">
    <h5>Automehanicar </h5>
    <p style="max-width:40vw"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu lacus vitae orci tempus placerat. In at leo sit amet elit scelerisque bibendum ut non nibh. Suspendisse interdum, urna at ullamcorper rhoncus, quam urna eleifend elit, eu lobortis libero quam at odio</p>

    <img src="jobPhoto.png">
    <h5>It menadzer </h5>
    <p style="max-width:40vw"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu lacus vitae orci tempus placerat. In at leo sit amet elit scelerisque bibendum ut non nibh. Suspendisse interdum, urna at ullamcorper rhoncus, quam urna eleifend elit, eu lobortis libero quam at odio</p>

    <img src="jobPhoto.png">
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
    document.querySelector(".afterJobDiv").innerHTML=`  <h2 class="h2align" style="margin-top: 5rem;">Vas Audi</h1>
    </br>

    `
}

function getEmployeeInput(){
  const array=[];
  var first=document.querySelector(".employee1").value;
  var second=document.querySelector(".employee2").value;
  if(first.length>3 && second.length>5){
    alert("Uspesno ste poslali CV")
    array.push(first);
    array.push(second);
  }else{
    alert("Uneli ste pogresne podatke")
  }
}


function getListInput(){
var array =   document.getElementById("my-form").elements;

if(array[0].value.includes(" ") || hasNumbers(array[0].value) || array[1].value.includes(" ") || hasNumbers(array[1].value)){
  alert("Ime i prezime moraju biti jedna rec i bez razmaka")
}else if(array[3].value.length>200 || array[3].value.length<10 ){
  alert("Min unos je 10 reci, a max unos je 200 reci")
  


}
}

function addMap(){
mapboxgl.accessToken = 'pk.eyJ1IjoidmlrdG9yY3ZldGFub3ZpYyIsImEiOiJja2oyNDM2c3A1MHNjMnFsYnZodmx1Mmh6In0.HcWpNazoTdm1XK690ZVErQ';
var map = new mapboxgl.Map({
container: 'map',
style: 'mapbox://styles/mapbox/streets-v11'
});}

function hasNumbers(t)
{
var regex = /\d/g;
return regex.test(t);
}    

function showPrice(){
  var element=document.querySelectorAll(".selectModel");
  var packet=0;
  var preuzimanje=0;
  var brRata=element[1].value;
  var cena=0;
  if(element[2].value==="FULL"){
    packet=5000;
  }else{
    packet=2000;
  }
  if(element[3].value==="LICNO"){
    preuzimanje=1000;
  }else{
    preuzimanje=2000;
  }
  
  switch(element[0].value){
    case "A4":
      cena=40000;
      break;
      case "A6":
        cena=60000;
        break;
        case "A7":
          cena=70000;
          break;
          case "A8":
            cena=100000;
            break;
            case "TT":
              cena=120000;
              break;
              case "R8":
                cena=220000;
                break;

      
  }

  createPrice(Math.round((cena+preuzimanje+packet)/brRata));
}

function createPrice(price){
  document.querySelector(".prikazCene").innerHTML=`<h2 class="h2align">Vasa mesecna rata automobila je </h2>
  <p>${price}$ </p>
  `
}
function createTable(){
    var a=document.querySelector(".unos").value;
    var b=document.querySelector(".unos2").value;
    var c=document.querySelector(".unos3").value;
  
    var m="Ne";
    if(c>35){
        m="Da"
    }
    document.querySelector(".table").innerHTML+=`  <tr>
    <th>${a}</th>
    <th>${b}</th> 
    <th>${c}</th>
    <th>${m}</th>
  </tr>`
}
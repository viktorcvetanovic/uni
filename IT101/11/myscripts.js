function showAlert(){
    alert("Viktor Cvetanovic 4421")
}

function showMore(){
    document.querySelector(".output").innerHTML="Ovo je Javascript funkcija"
}
function showLess(){
    document.querySelector(".output").innerHTML=""
}
if(document.querySelector(".dugme")){
document.querySelector(".dugme").addEventListener('click', ()=>{
    document.querySelector(".text").innerHTML="Ovo je novi text";
    alert("Uspesno ste promenili text")
        
});
}
if(document.querySelector(".dugme2")){
document.querySelector(".dugme2").addEventListener('click', ()=>{
    document.querySelector(".output").innerHTML=`<p> Tekst koji ste uneli je<p>`+ document.querySelector(".unosTeksta").value;
  
        
});
}
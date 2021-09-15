var pPoeni=document.querySelector(".predispitniPoeni");
var iPoeni=document.querySelector(".ispitniPoeni");
document.querySelector(".dugme").disabled = true;
var niz=[];

function getAllInput(){
  
    for(let i=1;i<5;i++){
        var input=document.querySelector(".unos" +i);
        niz.push(input.value);
    }

}

function plus(){
    var zbir=0;
    for(let i=0;i<niz.length;i++){
        zbir+=parseInt(niz[i]);
    }
    
    
    return zbir;

}

function enableButton(){
    if(plus()>=35)
    document.querySelector(".dugme").disabled = false;
    else{
        document.querySelector(".dugme").disabled = true;
    }
}

function createDiv(){
    if(plus()>=35){
       pPoeni.innerHTML=`<p>Viktor Cvetanovic</br><b>Imate</b> uslov za izlazak na ispit.</br>Ukupno predispitnih poena imate : ${plus()}</p>`
    }
    else if (plus()>0 && plus()<35){
        pPoeni.innerHTML=`<p>Viktor Cvetanovic</br><b>Nemate</b> uslov za izlazak na ispit.</br>Ukupno predispitnih poena imate : ${plus()}</p>`
    }
    else{
        pPoeni.innerHTML=`<p>Uneli ste pogresan broj poena</p>`
    }
    
}

function getIspit(){
    return document.querySelector(".unosIspita").value;
}

function checkPoints(){
if(getIspit()<=50){
    createIspitDiv(5);
}
else if(getIspit()<=60){
    createIspitDiv(6);
}
else if(getIspit()<=70){
    createIspitDiv(7);
}
else if(getIspit()<=80){
    createIspitDiv(8);
}
else if(getIspit()<=90){
    createIspitDiv(9);
}
else if(getIspit()<=100){
    createIspitDiv(10);
}
else{
    alert("POGRESAN BROJ POENA")
}


}

function createIspitDiv(poeni){
    iPoeni.innerHTML=`<p>Vasa ocena je ${poeni}</p>`;
}
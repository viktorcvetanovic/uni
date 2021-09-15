

function createInput(){
    var duzina=document.querySelector(".unos").value;    
    for (let i=0;i<duzina;i++){
        document.querySelector(".output").innerHTML+=`<label> Ovo je ${i+1} unos</label><input type="text" class=unos${i}><br>`
    }
}

function plus(){
    var duzina=document.querySelector(".unos").value;
    var rezultat=0;
    for (let i=0;i<duzina;i++){
        var value=parseInt(document.querySelector(".unos"+i).value);
        rezultat+=value;
        
        
    }
    document.querySelector(".output").innerHTML+=`<span>Rezultat je ${rezultat}</span><br>`   
    rezultat=0;
}
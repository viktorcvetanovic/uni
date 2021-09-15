var div=document.querySelector(".mainDiv");

function createInput(){
   div.innerHTML+=`<input type="text">`
}

function removeLast(){
    div.removeChild(div.lastChild);
}

function isMax(){
    var max=0;
    inputs = document.getElementsByTagName('input');
   
    for (i = 0; i < inputs.length; ++i) {
        if(inputs[i].value>max){
            max=inputs[i].value;
        }
    }
    console.log(max);
}
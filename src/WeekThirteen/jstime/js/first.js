let name = prompt("Please Enter Your Name!")

let tag = document.querySelector("#tag")

tag.innerHTML = `${tag.innerHTML}${name}`



function showTime(){
    const dateTime = new Date();
    
    document.querySelector("#time").innerHTML = dateTime;
   
}

setInterval(showTime, 1000)
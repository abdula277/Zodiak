window.onload = setCurrentDate;

function setCurrentDate() {
    var addr = window.location.href;
    if (addr.indexOf("date") === -1) {
        document.getElementById("datePicker").valueAsDate = new Date();
    }else {
        document.getElementById("datePicker").value = addr.substring(addr.indexOf("date") + 5, addr.length);
    }
}

function updateZodiak(value){
    console.log(value);
    window.location.href = '/?date=' + value;
}
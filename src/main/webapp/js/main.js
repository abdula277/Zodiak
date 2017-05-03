window.onload = setCurrentDate;

function setCurrentDate() {
    var myDate = new Date();
    var date = myDate.getFullYear() + '-' + ('0'+(myDate.getMonth()+1)).slice(-22) + '-' + ('0'+ myDate.getDate()).slice(-2);
    $("#datepicker").val(date);
    updateZodiak($("#datepicker").val());
}

function updateZodiak(value){
    $.ajax({
        url: '/resolveZodiak?date=' + value,
        dataType: "text",
        success: function(text) {
            $("#zodiakField").text(text);
        }
    });
}
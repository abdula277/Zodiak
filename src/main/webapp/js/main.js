window.onload = setCurrentDate;

function setCurrentDate() {
    var myDate = new Date();
    var date = myDate.getFullYear() + '-' + ('0'+(myDate.getMonth()+1)).slice(-22) + '-' + ('0'+ myDate.getDate()).slice(-2);
    $("#datepicker").val(date);
    updateZodiak($("#datepicker").val());

}

function updateZodiak(value){

    if (!isValidDate(value)) {
        $('#le-alert').show();
        console.log(value);
        console.log(new Date(value).toISOString());
    }else {
        $.ajax({
            url: '/resolveZodiak?date=' + value,
            dataType: "text",
            success: function (text) {
                $("#zodiakField").text(text);
            }

        });
    }

}

function isValidDate(date)
{

    var matches = /^(\d{4})[-\/](\d{1,2})[-\/](\d{1,2})$/.exec(date);

    if (matches == null) return false;
    var parts = date.match(/(\d+)/g);
    var m = matches[2] - 1; // months are 0-based
    var y = matches[1];
    var d = matches[3];
    var line = parts[0] + "-" + parts[1] + "-" + parts[2]; //to avoid 2017-05-31-> 2017-06-01
    var composedDate = new Date(line);
    return composedDate.getDate() == d &&
        composedDate.getMonth() == m &&
        composedDate.getFullYear() == y;
}
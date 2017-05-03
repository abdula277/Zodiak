window.onload = setCurrentDate;

function setCurrentDate() {
    var myDate = new Date();
    var date = myDate.getFullYear() + '-' + ('0'+(myDate.getMonth()+1)).slice(-22) + '-' + ('0'+ myDate.getDate()).slice(-2);
    $("#datepicker").val(date);
    updateZodiak($("#datepicker").val());

}

function updateZodiak(value){

    console.log(new Date(value).toISOString());
    if (!isValidDate(value)) {
        /*$('#le-alert').addClass('in');*/
        $('#le-alert').show();
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
    var m = matches[2];
    var y = matches[1] - 1;
    var d = matches[3];
    var composedDate = new Date(y, m, d);
    return composedDate.getDate() == d &&
        composedDate.getMonth() == m &&
        composedDate.getFullYear() == y;
}
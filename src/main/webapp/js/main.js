window.onload = initPage;

function initPage(){
    $( function() {
        $("#datepicker").attr("placeholder", "mm-dd-yyyy").datepicker({
            showButtonPanel: true,
            changeMonth: true,
            changeYear: true,
            yearRange: '1920:2020',
            showAnim: 'slideDown',
            dateFormat: 'yy-mm-dd',
            onSelect: function() {
                $(this).change();
                updateZodiak();
            }
        })
    });
    $('.close').click(function () {
        $('#le-alert').hide();
    });
    setCurrentDate();
}

function setCurrentDate() {
    var myDate = new Date();
    var date = myDate.getFullYear() + '-' + ('0'+(myDate.getMonth()+1)).slice(-22) + '-' + ('0'+ myDate.getDate()).slice(-2);
    $("#datepicker").val(date);
    $('#showHideHoro').unbind('click').click(showHoroscope)
    updateZodiak();
}

function updateZodiak(){
    var value = $("#datepicker").val();
    hideHoroscope();
    if (!isValidDate(value)) {
        $('#le-alert').show();
        $("#zodiakField").text("???");
        $('#showHideHoro').attr('disabled', 'disabled');
    }else {
        $.ajax({
            url: '/resolveZodiak?date=' + value,
            dataType: "text",
            success: function (text) {
                $("#zodiakField").text(text);
                $('#le-alert').hide();
                $('#showHideHoro').removeAttr('disabled');
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

function showHoroscope(){
    $.ajax({
        url: '/getHoroscope?date=' + $("#datepicker").val(),
        dataType: "text",
        success: function (text) {
            $("#horo").text(text);
            $("#horoDiv").show();
            $('#showHideHoro').unbind('click').click(hideHoroscope);
        }
    });
}

function hideHoroscope() {
    $('#showHideHoro').unbind('click').click(showHoroscope);
    $("#horo").text("");
    $("#horoDiv").hide();

}
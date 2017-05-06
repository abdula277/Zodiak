<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="./webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/main.css"/>
<link rel="stylesheet" href="./webjars/jquery-ui/1.12.1/jquery-ui.css">

<head>
    <meta charset="UTF-8">
    <title>Zodiak Project</title>
</head>
<body>

    <div class="container">
        <div class="header clearfix">
            <h3 class="text-muted">The Zodiak Project</h3>
        </div>

        <div class="jumbotron">
            <h1><label for="datepicker">Введите любую дату:</label></h1>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <p class="lead">
                        <input type="text" id="datepicker" onfocusout="updateZodiak()">
                    </p>
                    <div id="le-alert" class="alert alert-danger alert-block fade in" role="alert" hidden>
                        <strong>О нет!</strong> Дата должна быть корректной! P.S. формат: 'yyyy-MM-dd'
                        <button href="#" type="button" class="close">&times;</button>
                    </div>
                    <p><h2>Знак Зодиака: <label id="zodiakField"></label>!</h2>
                    <button type="button" id="showHideHoro" class="btn btn-default">Показать гороскоп</button>
                    <br>
                    <br>
                    <div class="alert alert-info" id="horoDiv" hidden>
                        <p id="horo">
                        </p>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <script type="application/javascript" src="js/main.js"></script>
    <script type="text/javascript" src='webjars/jquery/3.2.0/jquery.min.js'></script>
    <script type="text/javascript" src='./webjars/jquery-ui/1.12.1/jquery-ui.min.js'></script>
    <script>
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
    </script>
</body>
</html>
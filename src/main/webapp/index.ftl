<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="./css/main.css"/>
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
            <h1><label for="datePicker">Введите любую дату:</label></h1>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <p class="lead">
                        <input id='datePicker' type='date' required onchange='updateZodiak(value)'>
                    </p>
                    <p>
                        <h2>Знак Зодиака: ${zodiak}!</h2>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <script type="application/javascript" src="/js/main.js"></script>
</body>
</html>
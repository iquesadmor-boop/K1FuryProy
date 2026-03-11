<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <title>Eliminar Liga</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>ELIMINAR LIGA</h4>
            </div>
        </header>
        <main>
            <div class="mainList">
            <#list ligas as liga>
                <label class="selector">${liga}<input class="checkboxSelectorEliminar" type="checkbox" name="liga" value="${liga}"></label>
            </#list>
                <button class="btn"><a href="confirmar-eliminar-liga.html">Eliminar</a></button>
            </div>
        </main>
        <footer>
            <div class="footer">
                <a href="menu.html"><i class="fa-solid fa-house"></i></a>
                <a href="gestion-liga.html"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-store, must-revalidate">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
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
            <form class="form" action="/confirmarEliminarLiga", method = "POST">
            <#list ligas as liga>
                <option value="" disabled selected hidden>${liga}</option>
                <option value="${liga}">${liga}</option>
            </#list>
            <label for="nombre">Nombre Liga</label>
            <input type="text" id="nombre" name="nombre">

               <input type="submit" value="Eliminar" class="btn">
               </form>

            </div>
        </main>
        <footer>
            <div class="footer">
                <a href="/menu"><i class="fa-solid fa-house"></i></a>
                <a href="/tLiga/gestion-liga"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
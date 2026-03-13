<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clasificacion</title>
<link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
                    <div class="headerTop">
                        <img src="/img/LogoFuryK1.png">
                    </div>

                    <div class="headerTitle">
                        <h4>CLASIFICACION</h4>
                    </div>
                </header>
        <main>
            <div class="mainList">
            <#list peleadores as peleador, victorias>
                <label class="selectorEliminar">${peleador.nombre} ${peleador.apellido} ${victorias}</label>
            </#list>
            </div>
        </main>
        <footer>
            <div class="footer">
                <a href="/menu"><i class="fa-solid fa-house"></i></a>
                <a href="/tClasificacion/clasificacion"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
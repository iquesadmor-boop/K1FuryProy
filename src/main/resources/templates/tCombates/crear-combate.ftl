<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Liga</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>NUEVO COMBATE</h4>
            </div>
        </header>

        <main>
            <div class="fury-form">
                <div class="EditarLiga">
                    <form class="fury-form" action="/crearCombate" method="POST">
                        
                        
                        <select class="selector" name="liga">
                        <#list ligas as liga>
                            <option value="" disabled selected  hidden>Liga</option>
                            <option value="${liga}">${liga}</option>
                        </#list>
                        </select>
                        
                        <label for="arbitroNombre">Nombre Arbitro</label>
                        <input type="text" id="arbitroNombre" name="arbitroNombre">

                        <label for="arbitroApellido">Apellido Arbitro</label>
                        <input type="text" id="arbitroApellido" name="arbitroApellido">

                        <label for="peleador1Nombre">Nombre Peleador 1</label>
                        <input type="text" id="peleador1Nombre" name="peleador1Nombre">

                        <label for="peleador1Apellido">Apellido Peleador 1</label>
                        <input type="text" id="peleador1Apellido" name="peleador1Apellido">

                        <label for="peleador2Nombre">Nombre Peleador 2</label>
                        <input type="text" id="peleador2Nombre" name="peleador2Nombre">

                        <label for="peleador2Apellido">Apellido Peleador 2</label>
                        <input type="text" id="peleador2Apellido" name="peleador2Apellido">

                        <input type="submit" value="Crear" class="btn">

                        </label>
                    </form>
                </div>
            </div>
        </main>

        <footer>
            <div class="footer">
                <a href="/menu"><i class="fa-solid fa-house"></i></a>
                <a href="/tCombates/combates"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
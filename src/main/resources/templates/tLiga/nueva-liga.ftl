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
                <h4>NUEVA LIGA</h4>
            </div>
        </header>

        <main>
            <div class="main">
                <div class="EditarLiga">
                    <form class="form" action="/crearLiga" method="POST">
                        <label for="nombre">Nombre liga</label>
                        <input type="text" id="nombre" name="nombre">

                        <select class="selector" name="peso">
                            <option value="" disabled selected  hidden>Peso</option>
                            <option value="72">K1 Fury 72Kg</option>
                            <option value="76">K1 Fury 76Kg</option>
                            <option value="80">K1 Fury 80Kg</option>
                        </select>

                        <label for="fecha_inicio">Fecha Inicio</label>
                        <input type="text" id="fecha_inicio" name="fecha_inicio">


                        <input type="submit" value="Crear" class="btn">

                        </label>
                    </form>
                </div>
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
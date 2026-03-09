<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Liga</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>
<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>EDITAR LIGA</h4>
            </div>
        </header>

        <main>
            <div class="main">
                <div class="EditarLiga">
                    <form class="form" method="POST" action="/editarLiga">
                        <select class="selector">
                            <option value="" disabled selected hidden>Seleccionar Liga</option>
                            <option value="72">K1 Fury 72Kg</option>
                            <option value="76">K1 Fury 76Kg</option>
                            <option value="80">K1 Fury 80Kg</option>
                        </select>
                        
                        <label for="nombre">Nuevo Nombre</label>
                        <input type="text" id="nombre" name="nombre">

                        <label for="fecha_fin">Fecha Fin</label>
                        <input type="text" id="nombre" name="nombre">

                        <input type="submit" value="Editar" class="btn">
                

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
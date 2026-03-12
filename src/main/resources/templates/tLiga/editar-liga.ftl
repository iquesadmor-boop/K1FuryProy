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
                        <select class="selector" name ="ligas">
                            <option value="" disabled selected hidden>Seleccionar Liga</option>
                            <#list ligas as liga>
                                <option value="${liga}">${liga}</option>
                            </#list>
                        </select>
                        
                        <label for="NuevoNombre">Nuevo Nombre</label>
                        <input type="text" id="NuevoNombre" name="NuevoNombre">

                        <label for="fecha_fin">Fecha Fin</label>
                        <input type="text" id="fecha_fin" name="fecha_fin">

                        <input type="submit" value="Editar" class="btn">
                

                        </label>
                    </form>
                </div>
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
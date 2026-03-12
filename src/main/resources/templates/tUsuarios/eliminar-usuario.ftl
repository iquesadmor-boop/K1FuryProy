<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Eliminar Usuario</title>
        <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>
<body>
        <div class="contenedor">
                <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>ELIMINAR USUARIO</h4>
            </div>
        </header>
                <main>
                        <div class="fury-form">
                                <form class="form" action="/eliminar-usuario", method = "POST">
                                     <label for="dni">DNI</label>
                                     <input type="text" id="dni" name="dni">
                                 <input type="submit" value="Eliminar" class="btn">
                                 </form>
                        </div>
                </main>
                <footer>
                        <div class="footer">
                                <a href="/menu"><i class="fa-solid fa-house"></i></a>
                                <a href="/tUsuarios/gestion-usuarios"><i class="fa-solid fa-arrow-left"></i></a>
                        </div>
                </footer>
        </div>
</body>
</html>
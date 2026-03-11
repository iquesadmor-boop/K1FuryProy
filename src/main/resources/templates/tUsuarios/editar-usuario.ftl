<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>EDITAR USUARIO</h4>
            </div>
        </header>
        <main>
            <div class="main">
                <form class="form" action="/editar-usuario", method = "POST">
                    <label for="nombreActual">Nombre actual</label>
                    <input type="text" id="nombreActual" name="nombreActual">
                    <label for="apellidoActual">Apelldio actual</label>
                    <input type="text" id="apellidoActual" name="apellidoActual">
                    <label for="nuevoNombre">Nuevo Nombre</label>
                    <input type="text" id="nuevoNombre" name="nuevoNombre">
                    <label for="nuevoApellido">Nuevo Apellido</label>
                    <input type="text" id="nuevoApellido" name="nuevoApellido">
                    <label for="pwd">Contraseña</label>
                    <input type="password" id="pwd" name="pwd">
                    <select class="selector" id="rol" name="rol">
                        <option value="1">Usuario</option>
                        <option value="3">Arbitro</option>
                        <option value="2">Peleador</option>
                        <option value="4">Administrador</option>
                    </select>
                    <input type="submit" value="Editar" class="btn">
                </form>
            </div>
        </main>
        <footer>
            <div class="footer">
                <a href="menu.html"><i class="fa-solid fa-house"></i></a>
                <a href="gestion-usuarios.html"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
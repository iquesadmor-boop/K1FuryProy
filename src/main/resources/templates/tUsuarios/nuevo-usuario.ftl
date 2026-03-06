<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Usuario</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/CSS/k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="ImgsLogo/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>NUEVO USUARIO</h4>
            </div>
        </header>
        <main>
            <div class="main">
                <form class="form" action="menu.html">
                    <label for="nombre">Usuario</label>
                    <input type="text" id="nombre" name="nombre">
                    <label for="correo">Correo</label>
                    <input type="email" id="correo" name="correo">
                    <label for="pwd">Contraseña</label>
                    <input type="password" id="pwd" name="pwd">
                    <select class="selector" id="tipoUsuario" name="tipoUsuario">
                        <option value="usuario">Usuario</option>
                        <option value="arbitro">Arbitro</option>
                        <option value="peleador">Peleador</option>
                        <option value="administrador">Administrador</option>
                    </select>
                    <input type="submit" value="Crear" class="btn">
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
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Usuario</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>NUEVO USUARIO</h4>
            </div>
        </header>
        <main>
            <div class="fury-form">
                <form class="fury-form" action="/nuevo-usuario" method="POST">
                    <label for="dni">Dni</label>
                    <input type="text" id="dni" name="dni">
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" name="nombre">
                    <label for="apellido">Apellido</label>
                    <input type="text" id="apellido" name="apellido">
                    <label for="pwd">Contraseña</label>
                    <input type="password" id="pwd" name="pwd">
                    <select class="selector" id="peso" name="peso">
                        <option value="72">72Kg</option>
                        <option value="76">76Kg</option>
                        <option value="80">80Kg</option>
                    </select>
                    <select class="selector" id="rol" name="rol">
                        <option value="1">Usuario</option>
                        <option value="3">Arbitro</option>
                        <option value="2">Peleador</option>
                        <option value="4">Administrador</option>
                    </select>
                    <input type="submit" value="Crear" class="btn">
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
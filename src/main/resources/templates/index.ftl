<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>
<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>
        </header>
        <main class="main">
            <div class="caja-form">
                <form class="form" action="autenticar" method="post">
                    <h1>LOGIN</h1>
                    <label for="nombre" >Usuario</label>
                    <input type="text" id="nombre" name="nombre">
                    <label for="pwd">Contraseña</label>
                    <input type="password" id="pwd" name="pwd">
                    <input type="submit" value="LOGIN" class="btn">
                </form>
            </div>
        </main>
    </div>
</body>
</html>
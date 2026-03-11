<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado Usuarios</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../k1Fury.css">
</head>

<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>LISTADO USUARIOS</h4>
            </div>
        </header>
        <main>
            <div class="mainList">
                 <#list usuarios as usuario>
                      <option value="" disabled selected hidden>${usuario}</option>
                      <option value="${usuario}">${usuario}</option>
                 </#list>
            </div>
        </main>
        <footer>
            <div class="footer">
                <a href="index.html"><i class="fa-solid fa-house"></i></a>
                <a href="gestion-usuarios.ftl"><i class="fa-solid fa-arrow-left"></i></a>
            </div>
        </footer>
    </div>
</body>

</html>
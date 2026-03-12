<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Anotar Resultados</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/k1Fury.css">
</head>
<body>
    <div class="contenedor">
        <header>
            <div class="headerTop">
                <img src="/img/LogoFuryK1.png">
            </div>

            <div class="headerTitle">
                <h4>ANOTAR RESULTADOS</h4>
            </div>
        </header>
        <main>
                    <div class="mainMatch">
                        <#list listaLigasConPeleas as ligaConPeleas>
                                                    <div class="combate_box">
                                                        <h2>${ligaConPeleas.nombreLiga}</h2>
                                                            <#list ligaConPeleas.peleas as pelea>
                                                                <div class="detalles_box">
                                                                    <div class="peleador_box">
                                                                        <p>${pelea.peleador1.nombre} ${pelea.peleador1.apellido}</p>
                                                                        <p>${pelea.peleador1.victorias}</p>
                                                                    </div>
                                                                    <div class="vs">
                                                                        <p>VS</p>
                                                                    </div>
                                                                     <div class="peleador_box">
                                                                        <p>${pelea.peleador2.nombre} ${pelea.peleador2.apellido}</p>
                                                                        <p>${pelea.peleador2.victorias}</p>
                                                                     </div>
                                                                </div>
                                                            </#list>
                                                            <#list ligaConPeleas.peleas as pelea>
                                                                <div class="box_anotar_resultados">
                                                                    <form action="/sumarVictoria" method="post">
                                                                        <div class="anotar_resultado_btn">
                                                                            <input type="hidden" name="idGanador" value="${pelea.peleador1.id}">
                                                                            <button class="btn_result_anotar">${pelea.peleador1.nombre} ${pelea.peleador1.apellido}</button>
                                                                        </div>
                                                                    </form>
                                                                    <form action="/sumarVictoria" method="post">
                                                                        <div class="anotar_resultado_btn">
                                                                            <input type="hidden" name="idGanador" value="${pelea.peleador2.id}">
                                                                            <button class="btn_result_anotar">${pelea.peleador2.nombre} ${pelea.peleador2.apellido}</button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </#list>
                                                    </div>
                        </#list>
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
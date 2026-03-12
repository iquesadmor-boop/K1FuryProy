package es.masanz.da.controller;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.RegistroDao;
import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class CombateController {
    private static Logger logger = LogManager.getLogger();

    public static void mostrarCrearCombate(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        List<String> ligas = LigaDao.getNombresLigas();
        model.put("ligas", ligas);
        context.render("templates/tCombates/crear-combate.ftl", model);
    }

    public static void procesarNuevoCombate (Context context) {
        logger.info("Creando Nuevo Combate");

        String liga = context.formParam("liga");
        String arbitroNombre = context.formParam("arbitroNombre");
        String arbitroApellido = context.formParam("arbitroApellido");
        String peleador1Nombre = context.formParam("peleador1Nombre");
        String peleador1Apellido = context.formParam("peleador1Apellido");
        String peleador2Nombre = context.formParam("peleador2Nombre");
        String peleador2Apellido = context.formParam("peleador2Apellido");


        RegistroDao.crearRegsitro(liga, arbitroNombre, arbitroApellido, peleador1Nombre, peleador1Apellido, peleador2Nombre, peleador2Apellido);
        context.redirect("/menu");
    }

    public static void sumarVictoria(Context context) {
        int idGanador = Integer.parseInt(context.formParam("idGanador"));
        UserService.sumarVictoria(idGanador);
        context.redirect("/tCombates/anotar-resultado");
    }
}

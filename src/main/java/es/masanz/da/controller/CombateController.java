package es.masanz.da.controller;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.RegistroDao;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Integer.parseInt;

public class CombateController {
    private static Logger logger = LogManager.getLogger();

    public static void procesarNuevoCombate (Context context) {
        logger.info("Creando Nuevo Combate");

        int peso = parseInt(context.formParam("peso"));
        String arbitroNombre = context.formParam("arbitroNombre");
        String arbitroApellido = context.formParam("arbitroApellido");
        String peleador1Nombre = context.formParam("peleador1Nombre");
        String peleador1Apellido = context.formParam("peleador1Apellido");
        String peleador2Nombre = context.formParam("peleador2Nombre");
        String peleador2Apellido = context.formParam("peleador2Apellido");


        RegistroDao.crearRegsitro(peso, arbitroNombre, arbitroApellido, peleador1Nombre, peleador1Apellido, peleador2Nombre, peleador2Apellido);
        context.redirect("/menu");
    }
}

package es.masanz.da.controller;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LigaController {
    private static Logger logger = LogManager.getLogger();

    public static void newLiga (Context context){
        logger.info("Creando Nueva Liga");
        Map<String, Object> model = new HashMap<>();
        model.put("nombre", "");
        model.put("contraseña", "");
        model.put("error", false);
        context.render("templates/tLiga/nueva-liga.ftl", model);
    }
}

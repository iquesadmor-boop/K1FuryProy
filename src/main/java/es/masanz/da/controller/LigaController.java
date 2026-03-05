package es.masanz.da.controller;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LigaController {
    private static Logger logger = LogManager.getLogger();

    public static void mostrarNuevaLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/nueva-liga.ftl", model);
    }

//    public static void procesarNuevaLiga (Context context){
//        logger.info("Creando Nueva Liga");
//
//        String nombre = context.formParam("nombre");
//        int peso = context;
//        Map<Integer,> =
//
//
//    }
}

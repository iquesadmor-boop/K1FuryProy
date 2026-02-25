package es.masanz.da.controller;

import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainController {
    private static Logger logger = LogManager.getLogger();

    public static void iniciar(Context context) {
        logger.info("iniciar");
        context.req().getSession().invalidate();
        Map<String, Object> model = new HashMap<>();
        model.put("username", "");
        model.put("error", false);
        context.render("/templates/adm/index.ftl", model);
    }
}

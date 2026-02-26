package es.masanz.da.controller;

import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class UserController {
    private static Logger logger = LogManager.getLogger();

//    public static void iniciar(Context context) {
//        logger.info("iniciar");
//        context.req().getSession().invalidate();
//        Map<String, Object> model = new HashMap<>();
//        model.put("username", "");
//        model.put("contraseña", "");
//        model.put("error", false);
//        context.render("public/templates/adm/index.ftl", model);
//    }

    public static void autenticar(@NotNull Context context) {
        String nombre = context.formParam("nombre");
        String pwd = context.formParam("pwd");
        logger.info("Logeando con las credenciales User: " + nombre + " Password " + pwd);
        if (UserService.autenticar(nombre, pwd)){
            logger.info("Ha ido mal");
            context.render("/templates/menu.ftl");
        } else {
            logger.info("Ha ido bien");
            context.render("/templates/index.ftl");
        }

    }
}

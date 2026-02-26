package es.masanz.da.controller;

import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class UserController {
//    private static Logger logger = LogManager.getLogger();

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
        if (UserService.autenticar(nombre, pwd)){
            context.render("/templates/menu.ftl");
        } else {
            context.render("/templates/index.ftl");
        }

    }
}

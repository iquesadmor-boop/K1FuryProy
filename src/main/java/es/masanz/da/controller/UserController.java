package es.masanz.da.controller;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.UserDao;
import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UserController {

    private static Logger logger = LogManager.getLogger();

    public static void autenticar(@NotNull Context context) {
        String nombre = context.formParam("nombre");
        String pwd = context.formParam("pwd");
        logger.info("Logeando con las credenciales User: " + nombre + " Password " + pwd);
        if (UserService.autenticar(nombre, pwd)){
            logger.info("Ha ido mal");
            context.redirect("/menu");
        } else {
            context.render("/login");
        }

    }

    public static void mostrarNuevoUsuario(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tUsuarios/nuevo-usuario.ftl", model);
    }

    public static void procesarNuevoUsuario (Context context){
        logger.info("Creando Nueva Usuario");

        String nombre = context.formParam("nombre");
        int peso = Integer.parseInt(context.formParam("peso"));
        String apellido = context.formParam("apellido");
        String pwd = context.formParam("contraseña");
        int rol = Integer.parseInt(context.formParam("rol"));


        UserDao.insertarUsuario(nombre,pwd,apellido,rol,peso);
        context.redirect("/menu");
    }
}

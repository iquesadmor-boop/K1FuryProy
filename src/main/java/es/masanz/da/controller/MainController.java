package es.masanz.da.controller;

import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    private static Logger logger = LogManager.getLogger();

    public static void iniciar(Context context) {
        logger.info("iniciar");
        context.req().getSession().invalidate();
        Map<String, Object> model = new HashMap<>();
        model.put("username", "");
        model.put("contraseña", "");
        model.put("error", false);
        context.render("templates/index.ftl", model);
    }

    public static void autenticar(@NotNull Context context) {
        String nombre = context.formParam("nombre");
        String pwd = context.formParam("pwd");
    }


    public static void mostrarMenu(@NotNull Context context) {
        List<String> acciones = UserService.getAccionesMenu();
        Map<String, Object> model = new HashMap<>();
        model.put("acciones",acciones);
        context.render("menu.ftl", model);
    }

    public static void mostrarGestionLiga(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/gestion-liga.ftl", model);
    }

    public static void mostrarListadoLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/listado-ligas.ftl", model);
    }

    public static void mostrarNuevaLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/nueva-liga.ftl", model);
    }

    public static void mostrarEditarLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/editar-liga.ftl", model);
    }

    public static void mostrarEliminarLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/eliminar-liga.ftl", model);
    }

    public static void mostrarCombates(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tCombates/combates.ftl", model);
    }



}

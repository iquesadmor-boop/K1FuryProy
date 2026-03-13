package es.masanz.da.controller;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.UserDao;
import es.masanz.da.service.LigaService;
import es.masanz.da.service.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UserController {

    private static Logger logger = LogManager.getLogger();

    public static void autenticar(@NotNull Context context) {

        String nombre = context.formParam("nombre");
        String pwd = context.formParam("pwd");

        logger.info("Intentando login con User: " + nombre);


        if (UserService.autenticar(nombre, pwd)) {
                context.redirect("/menu");
            } else {
                context.redirect("/login");
            }


    }

    public static void mostrarNuevoUsuario(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        List<String> listaLigas = LigaDao.getNombresLigas();
        model.put("listaLigas", listaLigas);
        context.render("templates/tUsuarios/nuevo-usuario.ftl", model);
    }

    public static void procesarNuevoUsuario (Context context){
        logger.info("Creando Nueva Usuario");

        String dni = context.formParam("dni");
        String nombre = context.formParam("nombre");
        String apellido = context.formParam("apellido");
        String pwd = context.formParam("contraseña");
        int rol = Integer.parseInt(context.formParam("rol"));
        int liga = LigaDao.getIdByNombre(context.formParam("liga"));


        UserService.crearUsuario(dni,nombre,pwd,apellido,rol,liga);
        context.redirect("/menu");
    }

    public static void mostrarEditarUsuario(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tUsuarios/editar-usuario.ftl", model);
    }

    public static void mostrarListadoUsuarios(Context context){
        TreeSet<String> usuarios = UserService.getNombresUsuarios();
        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", usuarios);
        context.render("templates/tUsuarios/listado-usuarios.ftl", model);
    }

    public static void procesarEditarUsuario(Context context){
        logger.info("Editando usuario");

        String dni = context.formParam("dni");
        String nombre = context.formParam("nombre");
        String apellido = context.formParam("apellido");
        String pwd = context.formParam("contraseña");
        int rol = Integer.parseInt(context.formParam("rol"));

        UserService.editarUsuario(dni,nombre,apellido,pwd,rol);
        context.redirect("/menu");
    }

    public static void mostrarEliminarUsuario(Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tUsuarios/eliminar-usuario.ftl", model);
    }

    public static void procesarEliminarUsuario (Context context){
        logger.info("Borrando usuario");

        String dni = context.formParam("dni");


        UserService.eliminarUsuario(dni);
        context.redirect("/menu");
    }
}

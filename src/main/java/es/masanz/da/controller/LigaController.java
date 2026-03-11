package es.masanz.da.controller;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.model.Usuario;
import es.masanz.da.service.LigaService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LigaController {
    private static Logger logger = LogManager.getLogger();

    public static void mostrarNuevaLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/nueva-liga.ftl", model);
    }

    public static void procesarNuevaLiga (Context context){
        logger.info("Creando Nueva Liga");

        String nombre = context.formParam("nombre");
        int peso = Integer.parseInt(context.formParam("peso"));
        String fecha_inicio = context.formParam("nombre");


        LigaDao.crearLiga(nombre,peso,fecha_inicio);
        context.redirect("/menu");
//        Map<String,Object> model= new HashMap<>();
//        model.put("nombre", nombre);
//        model.put("peso", peso);
//        model.put("fechaInicio", fecha_inicio);
//        model.put("peleadores", peleadores);

    }

    public static void procesarEditarLiga(Context context){
        logger.info("Editando la liga");

        String nombre = context.formParam("ligas");
        String NuevoNombre = context.formParam("NuevoNombre");
        String fecha_fin = context.formParam("fecha_fin");

        LigaDao.editarLiga(NuevoNombre,fecha_fin,nombre);
        context.redirect("/menu");
    }

    public static void mostrarEditarLiga(@NotNull Context context) {
        List<String> ligas = LigaService.getNombresLigas();
        Map<String, Object> model = new HashMap<>();
        model.put("ligas", ligas);
        context.render("templates/tLiga/editar-liga.ftl", model);
    }

    public static void mostrarListadoLiga(Context context){
        List<String> ligas = LigaService.getNombresLigas();
        Map<String, Object> model = new HashMap<>();
        model.put("ligas", ligas);
        context.render("templates/tLiga/listado-ligas.ftl", model);
    }


    public static void mostrarEliminarLiga(@NotNull Context context) {
        List<String> ligas = LigaService.getNombresLigas();
        Map<String, Object> model = new HashMap<>();
        model.put("ligas", ligas);
        context.render("templates/tLiga/eliminar-liga.ftl", model);
    }

}

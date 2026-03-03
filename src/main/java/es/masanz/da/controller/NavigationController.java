package es.masanz.da.controller;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class NavigationController {
    public static void mostrarGestionLiga(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/gestion-liga.ftl", model);
    }

    public static void mostrarListadoLiga(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tLiga/listado-ligas.ftl", model);
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

    public static void mostrarCombatesAnteriores(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tCombates/combates-anteriores.ftl", model);
    }

    public static void mostrarProximosCombates(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tCombates/proximos-combates.ftl", model);
    }

    public static void mostrarAnotarResultados(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/tCombates/anotar-resultados.ftl", model);
    }
}

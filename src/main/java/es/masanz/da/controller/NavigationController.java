package es.masanz.da.controller;

import es.masanz.da.dao.RegistroDao;
import es.masanz.da.model.LigaConPeleas;
import es.masanz.da.model.Usuario;
import es.masanz.da.service.CombateService;
import es.masanz.da.service.LigaService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NavigationController {

    public static void mostrarMenu(@NotNull Context context) {
        context.render("templates/menu.ftl");
    }

    public static void mostrarGestionLiga(@NotNull Context context){
        context.render("templates/tLiga/gestion-liga.ftl");
    }

    public static void mostrarGestionUsuario(@NotNull Context context) {
        context.render("templates/tUsuarios/gestion-usuarios.ftl");
    }


    public static void mostrarCombates(@NotNull Context context){
        context.render("templates/tCombates/combates.ftl");
    }

    public static void mostrarProximosCombates(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();

        List<LigaConPeleas> listaLigasConPeleas = CombateService.getListaLigaConPeleadores();
        model.put("listaLigasConPeleas", listaLigasConPeleas);

        context.render("templates/tCombates/proximos-combates.ftl", model);
    }

    public static void mostrarAnterioresCombates(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();

        List<LigaConPeleas> listaLigasConPeleas = CombateService.getListaLigaConPeleadoresFinalizadas();
        model.put("listaLigasConPeleas", listaLigasConPeleas);

        context.render("templates/tCombates/proximos-combates.ftl", model);
    }

    public static void mostrarAnotarResultados(@NotNull Context context){
        Map<String, Object> model = new HashMap<>();

        List<LigaConPeleas> listaLigasConPeleas = CombateService.getListaLigaConPeleadoresFinalizadas();
        model.put("listaLigasConPeleas", listaLigasConPeleas);

        context.render("templates/tCombates/anotar-resultado.ftl", model);
    }

    public static void mostrarMenuClasificaciones(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        List<String> ligas = LigaService.getNombresLigas();
        model.put("ligas", ligas);
        context.render("templates/tClasificacion/clasificacion.ftl", model);
    }


    public static void mostrarClasificacion(@NotNull Context context) {
        String nombreLiga = null;
        try {
            nombreLiga = context.pathParam("liga");
        } catch (Exception e) {
            System.out.println(e);
            context.redirect("/menu");
        }
        List<Usuario> listaPeleadores = LigaService.getPeleadoresByNombreLiga(nombreLiga);
        LinkedHashMap<Usuario, Integer> peleadores = new LinkedHashMap<>();

        for (Usuario u : listaPeleadores) {
            int victorias = LigaService.getVictorias(u.getId());
            peleadores.put(u,victorias);
        }

        Map <String, Object> model = new HashMap<>();
        model.put("nombreLiga", nombreLiga);
        model.put("peleadores", peleadores);
        context.render("templates/tClasificacion/clasif-peso.ftl", model);
    }



}

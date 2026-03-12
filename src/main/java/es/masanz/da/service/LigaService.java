package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.model.Liga;
import es.masanz.da.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class LigaService {

    public static boolean crearLiga(String nombre, int peso, String fechaInicio){
        return LigaDao.crearLiga(nombre, peso,fechaInicio);
    }

    public static List<Usuario> getPeleadores(int peso) {
        return LigaDao.getPeleadores(peso);
    }

    public static List<String > getNombresLigas() {
        return LigaDao.getNombresLigas();
    }

    public static List<String> getLigas(int id_liga){
        return LigaDao.getPeleadoresLiga(id_liga);
    }

    public static int getVictorias(int id) {
        return LigaDao.getVictorias(id);
    }

//    public static boolean editarLiga(String nombre, String fecha_fin){
//        return LigaDao.editarLiga(nombre, fecha_fin);
//    }
}

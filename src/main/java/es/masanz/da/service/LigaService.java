package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.model.Usuario;

import java.util.List;

public class LigaService {


    public static List<String > getNombresLigas() {
        return LigaDao.getNombresLigas();
    }

    public static List<String> getLigas(int id_liga){
        return LigaDao.getPeleadoresLiga(id_liga);
    }

    public static int getVictorias(int id) {
        return LigaDao.getVictorias(id);
    }

    public static List<Usuario> getPeleadoresByNombreLiga(String nombreLiga) {
        return LigaDao.getPeleadoresNombeLiga(nombreLiga);
    }

}

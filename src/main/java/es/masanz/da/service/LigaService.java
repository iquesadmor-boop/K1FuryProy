package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;
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


}

package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;

public class LigaService {

    public static boolean crearLiga(int peso, String fechaInicio){
        return LigaDao.crearLiga(peso,fechaInicio);
    }
}

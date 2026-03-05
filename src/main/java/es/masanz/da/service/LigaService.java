package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;

import java.time.LocalDate;

public class LigaService {

    public static boolean crearLiga(int peso, LocalDate fechaInicio){
        return LigaDao.crearLiga(peso,fechaInicio);
    }
}

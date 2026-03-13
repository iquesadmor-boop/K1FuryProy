package es.masanz.da.service;

import es.masanz.da.dao.RegistroDao;
import es.masanz.da.dao.UserDao;

public class CombateService {
    public static void crearRegsitro(String liga, String arbitroNombre, String arbitroApellido, String peleador1Nombre, String peleador1Apellido, String peleador2Nombre, String peleador2Apellido) {
        RegistroDao.crearRegsitro(liga, arbitroNombre, arbitroApellido, peleador1Nombre, peleador1Apellido, peleador2Nombre, peleador2Apellido);
    }

    public static boolean sumarVictoria(int id) {
        return UserDao.sumarVictoria(id);
    }
}

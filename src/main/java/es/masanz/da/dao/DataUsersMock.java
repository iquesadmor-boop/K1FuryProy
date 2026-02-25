package es.masanz.da.dao;

import es.masanz.da.model.Rol;
import es.masanz.da.model.Usuario;

import static es.masanz.da.config.Config.ROL_ADMIN;
import static es.masanz.da.config.Config.ROL_ADMIN_ID;

public class DataUsersMock {

    public static final Usuario[] usuarios = new Usuario[]{
        new Usuario(0, "admin", "admin", "admin", ROL_ADMIN_ID, 75),
        new Usuario(1, "admin1", "admin1", "admin1", ROL_ADMIN_ID, 75),

    };
}

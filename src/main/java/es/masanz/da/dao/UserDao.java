package es.masanz.da.dao;

import es.masanz.da.db.dbK1Fury;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {

    static {
        dbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();



    public static boolean autenticar(String nombre, String pwd) {
        String sql = "select nombre, contraseña " +
                "from k1furydb.usuario " +
                "where nombre = ? and contraseña = ?";

        Object[] params = {nombre, pwd};

        Object[][] resultado = dbK1Fury.ejecutarSelectSQL(sql, params);

            if (resultado != null && resultado.length == 1) {
            for (int i = 0; i < resultado.length; i++) {
                String name = (String) resultado[i][0];
                String pass = (String) resultado[i][1];
                if (name.equalsIgnoreCase(nombre)) {
                    if (pass.equals(pwd)) {
                        logger.info("Atenticación realizada con exito");
                        return true;

                    }
                }
            }
        }
        logger.info("Creedenciales no validas o no reconocidas");
        return false;
    }

}

package es.masanz.da.dao;

import es.masanz.da.db.dbK1Fury;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.time.LocalDate;

public class LigaDao {

    static {
        dbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();

    public static boolean crearLiga(int peso, String fechaInicio) {
        String sql = "insert into k1furydb.liga (peso,fecha_inicio)" +
                "values (?,?);";

        Object[] params = {peso, fechaInicio};

        long resultado = dbK1Fury.ejecutarInsertSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }





}

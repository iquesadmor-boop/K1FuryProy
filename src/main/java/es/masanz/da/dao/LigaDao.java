package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LigaDao {

    static {
        DbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();

    public static boolean crearLiga(int peso, LocalDate fechaInicio) {
        String sql = "INSERT into k1furydb.liga (peso,fecha_inicio)" +
                "VALUES (?,?);";

        Object[] params = {peso, fechaInicio};

        long resultado = DbK1Fury.ejecutarInsertSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }


    public static List<Usuario> getPeleadores(int peso) {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, contraseña, rol, peso FROM usuario WHERE peso = ?";
        Object[] params = {peso};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length >= 1) {
            for (int i = 0; i < resultado.length; i++) {
                Usuario u = new Usuario();
                int id = Integer.parseInt(resultado[i][0].toString());
                u.setId(id);
                // TODO: rellenar campos usuario consulta

                lista.add(u);
            }
        }
        return lista;
    }

}

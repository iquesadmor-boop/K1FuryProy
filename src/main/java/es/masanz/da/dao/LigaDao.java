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
        String sql = "insert into k1furydb.liga (peso,fecha_inicio)" +
                "values (?,?);";

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
                String nombre = (String) resultado[i][1];
                u.setNombre(nombre);
                String apellido = (String) resultado[i][2];
                u.setApellido(apellido);
                u.setPeso(peso);
                lista.add(u);
            }
        }
        return lista;
    }
<<<<<<< HEAD

    public static boolean updateLigaFecha_fin(int id, String fecha){
        String sql = "update k1furydb.liga " +
                "set fecha_fin = ? " +
                "where id = ?;";

        Object[] params = {fecha, id};

        long resultado = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }


    public static boolean updateCampeon(int id, int campeon){
        String sql = "update k1furydb.liga " +
                "set campeon = ? " +
                "where id = ?;";

        Object[] params = {campeon, id};

        long resultado = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }

    public static boolean terminarLiga(int id){
        String sql = "update k1furydb.liga " +
                "set activa = false " +
                "where id = ?;";

        Object[] params = {id};

        long resultado = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }

    public static boolean eliminarLiga(int id){
        String sql = "DELETE FROM k1furydb.liga WHERE id = ?;";

        Object[] params = {id};

        long resultado = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }


=======
>>>>>>> 798666b50a12073a833b923303142f77e0a3ba6e
}

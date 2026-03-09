package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Liga;
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

    public static boolean crearLiga(String nombre, int peso, String fechaInicio) {
        String sql = "INSERT into k1furydb.liga (nombre,peso,fecha_inicio)" +
                "VALUES (?,?,?);";

        Object[] params = {nombre, peso, fechaInicio};

        long resultado = DbK1Fury.ejecutarInsertSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }

    public static boolean editarLiga(String nombre, String fecha_fin, int id){
        String sql = "update liga " +
                "SET nombre = ?, fecha_fin = ? " +
                "where id = ? ";

        Object[] params = {nombre, fecha_fin, id};

        int resultado = DbK1Fury.ejecutarUpdateSQL(sql,params);

        if (resultado > 0){
            return true;
        } else {return false;}

    }

    public static int getIdByNombre(String nombre){
        String sql = "SELECT id FROM liga WHERE nombre = ?";
        Object[] params = {nombre};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql,params);

        return (int) resultado[0][0];
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

    public static List<String> getNombresLigas (String nombre){
        List<String> lista = new ArrayList<>();
        String sql = "select nombre " +
                "from liga" +
                "where id = id";
        Object[] params = {};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length >= 1){
            for (int i = 0; i < resultado.length; i++) {
                String nombre = resultado[i][0].toString();
                lista.add(nombre);
            }
        }

        return lista;
    }

    public static List<Liga> getLigas() {
        List<Liga> lista = new ArrayList<>();
        String sql = "select id, nombre, liga" +
                "from liga";
        Object[] params = {};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length >= 1){
            Liga l1 = new Liga();

        }

        return lista;
    }

    public static List<String> getPeleadoresLiga(int id_liga){
        List<String> lista = new ArrayList<>();
        String sql = "select concat(o.nombre, ' ', o.apellido) NombreCompleto " +
                "from usuario o join liga l on o.liga = l.id " +
                "where liga = ?";
        Object[] params = {};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

        for (int i = 0; i < resultado.length; i++) {
            String nombre = resultado[i][i].toString();
            lista.add(nombre);
        }
        return lista;
    }
}

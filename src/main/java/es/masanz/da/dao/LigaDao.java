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

    public static boolean editarLiga(String NuevoNombre, String fecha_fin, String nombre){
        String sql = "update liga " +
                "SET nombre = ?, fecha_fin = ? " +
                "where nombre = ? ";

        Object[] params = {NuevoNombre, fecha_fin, nombre };

        int resultado = DbK1Fury.ejecutarUpdateSQL(sql,params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }

    public static int getIdByNombre(String nombre){
        String sql = "SELECT id FROM liga WHERE nombre = ?";
        Object[] params = {nombre};
        int id_liga = 0;
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql,params);

        for (int i = 0; i < resultado.length; i++) {
            id_liga = Integer.parseInt(resultado[i][0].toString());
        }
        return  id_liga;
    }


    public static List<Usuario> getPeleadores(int peso) {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, contraseña, rol, peso, liga FROM usuario WHERE peso = ?";
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

    public static List<String> getNombresLigas (){
        List<String> lista = new ArrayList<>();
        String sql = "select nombre " +
                "from liga";

        Object[] params = {};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length >= 1){
            for (int i = 0; i < resultado.length; i++) {
                String nombreL = resultado[i][0].toString();
                lista.add(nombreL);
            }
        }

        return lista;
    }

//    public static List<Liga> getLigas() {
//        List<Liga> lista = new ArrayList<>();
//        String sql = "select id, nombre, liga" +
//                "from liga";
//        Object[] params = {};
//        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);
//
//        if (resultado != null && resultado.length >= 1){
//            Liga l1 = new Liga();
//
//        }
//
//        return lista;
//    }

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

    public static Liga getLigabyNombre(String liga) {
        String sql = "select id, nombre, peso, fecha_inicio, fecha_fin, campeon, activa " +
                "from liga " +
                "where nombre = ?";
        Object[] params = {liga};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);
        Liga l = new Liga();
        if (resultado != null && resultado.length > 0) {
            for (int i = 0; i < resultado.length; i++) {
                l.setId(Integer.parseInt(String.valueOf(resultado[i][0])));
                l.setNombre(String.valueOf(resultado[i][1]));
                l.setPeso(Integer.parseInt(String.valueOf(resultado[i][2])));
                l.setFechaInicio(String.valueOf(resultado[i][3]));
                l.setFechaFin(String.valueOf(resultado[i][4]));
//                l.setCampeon(Integer.valueOf(String.valueOf(resultado[i][5])));
//                l.setEstaActiva(Integer.valueOf(String.valueOf(resultado[i][6])));
            }
        }

        return l;
    }

//    public static boolean procesarEliminarLiga(String nombre){
//        int idLiga = getIdByNombre(nombre);
//
//        String sql = "update liga" +
//                "set id = 0, nombre = null, peso = 0, fecha_inicio = null, fecha_fin = null, activa = 0 " +
//                "where id = ?";
//        Object[] params = {idLiga};
//        int resultado = DbK1Fury.ejecutarUpdateSQL(sql, params);
//
//        if (resultado > 0){
//            return true;
//        } else {return false;}
//
//    }

    public static String getNombreById(int id) {
        String sql = "SELECT nombre FROM liga WHERE id = ?";
        Object[] params = {id};
        Object[][] res = DbK1Fury.ejecutarSelectSQL(sql, params);

        if (res != null && res.length > 0) {
            return res[0][0].toString();
        }
        return "";
    }
}

package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {

    static {
        DbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();



    public static boolean autenticar(String nombre, String pwd) {
        String sql = "select nombre, contraseña " +
                "from k1furydb.usuario " +
                "where nombre = ? and contraseña = ?";

        Object[] params = {nombre, pwd};

        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

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

    public static boolean insertarUsuario(String nombre, String pwd, String apellido, int rol, int peso) {
        String sql = "INSERT INTO k1furydb.usuario (nombre,contraseña, apellido, rol, peso) " +
                "VALUES (?, ?, ?, ?, ?);";

        Object[] params = {nombre, pwd, apellido, rol, peso};

        long res = DbK1Fury.ejecutarInsertSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioNombre(String nombre, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET nombre = ? " +
                "WHERE id = ?";

        Object[] params = {nombre, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioApellido(String apellido, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET apellido = ? " +
                "WHERE id = ?";

        Object[] params = {apellido, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioPwd(String contraseña, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET contraseña = ? " +
                "WHERE id = ?";

        Object[] params = {contraseña, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioRol(int rol, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET rol = ? " +
                "WHERE id = ?";

        Object[] params = {rol, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioPeso(int peso, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET peso = ? " +
                "WHERE id = ?";

        Object[] params = {peso, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM k1furydb.usuario WHERE id = ?";

        Object[] params = {id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static void main(String[] args) {
        System.out.println(eliminarUsuario(44));
    }

    public static Usuario getUsuarioByNombreApellido(String nombre, String apellido) {
        String sql = "select id, nombre, apellido, contraseña, rol, peso, liga, victorias " +
                "from usuario " +
                "where nombre = ? and apellido = ?";

        Object[] params = {nombre, apellido};

        Object[][] res = DbK1Fury.ejecutarSelectSQL(sql, params);
        Usuario u = new Usuario();

        if (res.length > 0 && res != null){

            for (int i = 0; i < res.length; i++) {
                u.setId(Integer.parseInt(String.valueOf(res[i][0])));
                u.setNombre(String.valueOf(res[i][1]));
                u.setApellido(String.valueOf(res[i][2]));
                u.setPassword(String.valueOf(res[i][3]));
                u.setRol(Integer.parseInt(String.valueOf(res[i][4])));
                u.setPeso(Integer.parseInt(String.valueOf(res[i][5])));
                u.setLiga(Integer.parseInt(String.valueOf(res[i][6])));
                u.setVictorias(Integer.parseInt(String.valueOf(res[i][7])));
            }
        }
        return u;
    }
}

package es.masanz.da.dao;

import es.masanz.da.db.dbK1Fury;
import es.masanz.da.model.Usuario;
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

    public static boolean insertarUsuario(String nombre, String pwd, String apellido, int rol, int peso) {
        String sql = "INSERT INTO k1furydb.usuario (nombre,contraseña, apellido, rol, peso) " +
                "VALUES (?, ?, ?, ?, ?);";

        Object[] params = {nombre, pwd, apellido, rol, peso};

        long res = dbK1Fury.ejecutarInsertSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioNombre(String nombre, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET nombre = ? " +
                "WHERE id = ?";

        Object[] params = {nombre, id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioApellido(String apellido, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET apellido = ? " +
                "WHERE id = ?";

        Object[] params = {apellido, id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioPwd(String contraseña, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET contraseña = ? " +
                "WHERE id = ?";

        Object[] params = {contraseña, id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioRol(int rol, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET rol = ? " +
                "WHERE id = ?";

        Object[] params = {rol, id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioPeso(int peso, int id) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET peso = ? " +
                "WHERE id = ?";

        Object[] params = {peso, id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM k1furydb.usuario WHERE id = ?";

        Object[] params = {id};

        long res = dbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }


    public static Usuario getUsuario(int id){
        String sql = "SELECT id, nombre, apellido, contraseña, rol, peso FROM usuario WHERE id = ?";

        Object[] params = {id};

        Object[][] resultados = dbK1Fury.ejecutarSelectSQL(sql, params);

        if (resultados[0][0] == null) {
            return null;}
        else {
            Usuario usuario = new Usuario();
            usuario.setId((Integer) resultados[0][0]);
            usuario.setNombre((String) resultados[0][1]);
            usuario.setApellido((String) resultados[0][2]);
            usuario.setPassword((String) resultados[0][3]);
            usuario.setRol((Integer) resultados[0][4]);
            usuario.setPeso((Integer) resultados[0][5]);
            return usuario;
        }
    }



    public static void main(String[] args) {
        System.out.println(eliminarUsuario(44));
    }

}

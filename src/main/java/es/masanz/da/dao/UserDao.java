package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    static {
        DbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();



    public static boolean autenticar(String nombre, String pwd) {
        try {
        String sql = "select nombre, contraseña " +
                "from k1furydb.usuario " +
                "where nombre = ? and contraseña = ?";

            Object[] params = {nombre, pwd};
            Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

            if (resultado == null || resultado.length == 0) {
                return false;
            }

            String name = String.valueOf(resultado[0][0]);
            String pass = String.valueOf(resultado[0][1]);

            return true;

        } catch (Exception e) {
            logger.error("Error en autenticar: " + e.getMessage());
            return false;
        }


    }


    public static boolean insertarUsuario(String dni ,String nombre, String pwd, String apellido, int rol, int peso) {
        String sql = "INSERT INTO k1furydb.usuario (dni, nombre,contraseña, apellido, rol, peso) " +
                "VALUES (?,?, ?, ?, ?, ?);";

        Object[] params = {dni, nombre, pwd, apellido, rol, peso};

        long res = DbK1Fury.ejecutarInsertSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuario(String dni, String nuevoNombre ,String nuevoApellido, String pwd, int rol) {
        String sql = "UPDATE k1furydb.usuario " +
                "SET nombre = ?, contraseña = ?, apellido = ?, rol = ? " +
                "WHERE dni = ? ";

        Object[] params = {nuevoNombre, pwd, nuevoApellido, rol, dni};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean eliminarUsuario(String dni) {
        String sql = "DELETE FROM k1furydb.usuario WHERE dni = ?";

        Object[] params = {dni};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static List<String> getNombresUsuarios (){
        List<String> lista = new ArrayList<>();
        String sql = "select concat(nombre, ' ' , apellido) " +
                "from usuario ";

        Object[] params = {};
        Object[][] resultado = DbK1Fury.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length >= 1){
            for (int i = 0; i < resultado.length; i++) {
                String nombreU = String.valueOf(resultado[i][0]);
                if (! nombreU.equals("null")) {
                    lista.add(nombreU);
                }
            }
        }

        return lista;
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
                //u.setVictorias(Integer.parseInt(String.valueOf(res[i][7])));
            }
        }
        return u;
    }

    public static Usuario getUsuarioById(int id) {
        String sql = "select id, nombre, apellido, contraseña, rol, peso, liga, victorias " +
                "from usuario " +
                "where id = ?";

        Object[] params = {id};

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

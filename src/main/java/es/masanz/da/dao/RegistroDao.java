package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistroDao {
    static {
        DbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();

    public static boolean crearRegsitro(String liga, String arbitroNombre, String arbitroApellido, String peleador1Nombre, String peleador1Apellido, String peleador2Nombre, String peleador2Apellido){
        String sql = "INSERT into k1furydb.registros (liga, idArbitro, idPeleadorUno, idPeleadorDos)" +
                "VALUES (?,?,?,?);";

        Usuario arbitro = UserDao.getUsuarioByNombreApellido(arbitroNombre, arbitroApellido);
        Usuario peleador1 = UserDao.getUsuarioByNombreApellido(peleador1Nombre, peleador1Apellido);
        Usuario peleador2 = UserDao.getUsuarioByNombreApellido(peleador2Nombre, peleador2Apellido);

        int idArbitro = arbitro.getId();
        int idPeleadorUno = peleador1.getId();
        int idPeleadorDos = peleador2.getId();
        //int idLiga = liga.getIdFromNombre();

        Object[] params = {liga, idArbitro, idPeleadorUno, idPeleadorDos };

        long resultado = DbK1Fury.ejecutarInsertSQL(sql, params);

        if (resultado > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioPeso(int peso, int id) {
        String sql = "UPDATE k1furydb.registros " +
                "SET peso = ? " +
                "WHERE id = ?";

        Object[] params = {peso, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioIdArbitro(int idArbitro, int id) {
        String sql = "UPDATE k1furydb.registros " +
                "SET idArbitro = ? " +
                "WHERE id = ?";

        Object[] params = {idArbitro, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioIdPeleadorUno(int idPeleadorUno, int id) {
        String sql = "UPDATE k1furydb.registros " +
                "SET idPeleadorUno = ? " +
                "WHERE id = ?";

        Object[] params = {idPeleadorUno, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioIdPeleadorDos(int idPeleadorDos, int id) {
        String sql = "UPDATE k1furydb.registros " +
                "SET idPeleadorDos = ? " +
                "WHERE id = ?";

        Object[] params = {idPeleadorDos, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean actualizarUsuarioIdGanador(int idGanador, int id) {
        String sql = "UPDATE k1furydb.registros " +
                "SET idGanador = ? " +
                "WHERE id = ?";

        Object[] params = {idGanador, id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }

    public static boolean eliminarRegistro(int id) {
        String sql = "DELETE FROM k1furydb.registros WHERE id = ?";

        Object[] params = {id};

        long res = DbK1Fury.ejecutarUpdateSQL(sql, params);

        if (res > 0){
            return true;
        } else {return false;}
    }
}

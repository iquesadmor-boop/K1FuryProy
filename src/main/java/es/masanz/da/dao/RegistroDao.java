package es.masanz.da.dao;

import es.masanz.da.db.DbK1Fury;
import es.masanz.da.model.Liga;
import es.masanz.da.model.LigaConPeleas;
import es.masanz.da.model.Pelea;
import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RegistroDao {
    static {
        DbK1Fury.conectar("k1furydb", "proyfuryk1", "password");
    }

    private static Logger logger = LogManager.getLogger();

    public static boolean crearRegsitro(String liga, String arbitroNombre, String arbitroApellido, String peleador1Nombre, String peleador1Apellido, String peleador2Nombre, String peleador2Apellido){
        String sql = "INSERT into k1furydb.registros (liga, arbitro, peleador1, peleador2)" +
                "VALUES (?,?,?,?);";

        Usuario arbitro = UserDao.getUsuarioByNombreApellido(arbitroNombre, arbitroApellido);
        Usuario peleador1 = UserDao.getUsuarioByNombreApellido(peleador1Nombre, peleador1Apellido);
        Usuario peleador2 = UserDao.getUsuarioByNombreApellido(peleador2Nombre, peleador2Apellido);
        Liga l = LigaDao.getLigabyNombre(liga);

        int idArbitro = arbitro.getId();
        int idPeleadorUno = peleador1.getId();
        int idPeleadorDos = peleador2.getId();
        int idLiga = l.getId();

        Object[] params = {idLiga, idArbitro, idPeleadorUno, idPeleadorDos};

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

    public static List<LigaConPeleas> getListaLigaConPeleadores(){
        List<LigaConPeleas> res = new ArrayList<>();

        String sql1="select id, nombre " +
                "from liga " +
                "order by peso asc";

        Object[] params1 = {};
        Object[][] resultado1 = DbK1Fury.ejecutarSelectSQL(sql1, params1);

        if (resultado1 != null && resultado1.length > 0) {
            for (int i = 0; i < resultado1.length; i++) {
                LigaConPeleas dto = new LigaConPeleas();
                int idLiga = (int) resultado1[i][0];
                String nombreLiga = (String) resultado1[i][1];
                dto.setNombreLiga(nombreLiga);

                String sql2="select " +
                        "r.peleador1, u1.nombre as 'nombre1', u1.apellido as 'apellido1', u1.victorias as 'victorias1', " +
                        "r.peleador2, u2.nombre as 'nombre2', u2.apellido as 'apellido2', u2.victorias as 'victorias2' " +
                        "from registros r " +
                        "join usuario u1 on r.peleador1 = u1.id   " +
                        "join usuario u2 on r.peleador2 = u2.id " +
                        "where u1.rol = 2 and u2.rol = 2 and r.finalizada = 0" +
                        "and r.liga = ?";

                Object[] params2 = {idLiga};
                Object[][] resultado2 = DbK1Fury.ejecutarSelectSQL(sql2, params2);

                if (resultado2 != null && resultado2.length > 0) {
                    for (int j = 0; j < resultado2.length; j++) {

                        Usuario peleador1 = new Usuario();
                        int idPeleador1 = (int) resultado2[j][0];
                        peleador1.setId(idPeleador1);
                        String nombrePeleador1 = (String) resultado2[j][1];
                        peleador1.setNombre(nombrePeleador1);
                        String apellidoPeleador1 = (String) resultado2[j][2];
                        peleador1.setApellido(apellidoPeleador1);
                        int victoriasPeleador1 = (int) resultado2[j][3];
                        peleador1.setVictorias(victoriasPeleador1);

                        Usuario peleador2 = new Usuario();
                        int idPeleador2 = (int) resultado2[j][4];
                        peleador2.setId(idPeleador2);
                        String nombrePeleador2 = (String) resultado2[j][5];
                        peleador2.setNombre(nombrePeleador2);
                        String apellidoPeleador2 = (String) resultado2[j][6];
                        peleador2.setApellido(apellidoPeleador2);
                        int victoriasPeleador2 = (int) resultado2[j][7];
                        peleador2.setVictorias(victoriasPeleador2);

                        Pelea pelea = new Pelea(peleador1, peleador2);
                        dto.addPelea(pelea);
                    }
                }
                res.add(dto);
            }
        }
        return res;
    }

    public static List<LigaConPeleas> getListaLigaConPeleadoresFinalizadas(){
        List<LigaConPeleas> res = new ArrayList<>();

        String sql1="select id, nombre " +
                "from liga " +
                "order by peso asc";

        Object[] params1 = {};
        Object[][] resultado1 = DbK1Fury.ejecutarSelectSQL(sql1, params1);

        if (resultado1 != null && resultado1.length > 0) {
            for (int i = 0; i < resultado1.length; i++) {
                LigaConPeleas dto = new LigaConPeleas();
                int idLiga = (int) resultado1[i][0];
                String nombreLiga = (String) resultado1[i][1];
                dto.setNombreLiga(nombreLiga);

                String sql2="select " +
                        "r.peleador1, u1.nombre as 'nombre1', u1.apellido as 'apellido1', u1.victorias as 'victorias1', " +
                        "r.peleador2, u2.nombre as 'nombre2', u2.apellido as 'apellido2', u2.victorias as 'victorias2' " +
                        "from registros r " +
                        "join usuario u1 on r.peleador1 = u1.id   " +
                        "join usuario u2 on r.peleador2 = u2.id " +
                        "where u1.rol = 2 and u2.rol = 2 and r.finalizada = 0" +
                        "and r.liga = ?";

                Object[] params2 = {idLiga};
                Object[][] resultado2 = DbK1Fury.ejecutarSelectSQL(sql2, params2);

                if (resultado2 != null && resultado2.length > 0) {
                    for (int j = 0; j < resultado2.length; j++) {

                        Usuario peleador1 = new Usuario();
                        int idPeleador1 = (int) resultado2[j][0];
                        peleador1.setId(idPeleador1);
                        String nombrePeleador1 = (String) resultado2[j][1];
                        peleador1.setNombre(nombrePeleador1);
                        String apellidoPeleador1 = (String) resultado2[j][2];
                        peleador1.setApellido(apellidoPeleador1);
                        int victoriasPeleador1 = (int) resultado2[j][3];
                        peleador1.setVictorias(victoriasPeleador1);

                        Usuario peleador2 = new Usuario();
                        int idPeleador2 = (int) resultado2[j][4];
                        peleador2.setId(idPeleador2);
                        String nombrePeleador2 = (String) resultado2[j][5];
                        peleador2.setNombre(nombrePeleador2);
                        String apellidoPeleador2 = (String) resultado2[j][6];
                        peleador2.setApellido(apellidoPeleador2);
                        int victoriasPeleador2 = (int) resultado2[j][7];
                        peleador2.setVictorias(victoriasPeleador2);

                        Pelea pelea = new Pelea(peleador1, peleador2);
                        dto.addPelea(pelea);
                    }
                }
                res.add(dto);
            }
        }
        return res;
    }

}
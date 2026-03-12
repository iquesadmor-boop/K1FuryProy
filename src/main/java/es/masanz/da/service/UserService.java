package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.UserDao;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import static es.masanz.da.config.Config.*;

public class UserService {


    public static boolean autenticar(String nombre, String pwd) {
        return UserDao.autenticar(nombre, pwd);
    }

    public static boolean crearUsuario(String dni ,String nombre, String pwd, String apellido, int rol, int peso){
        return UserDao.insertarUsuario(dni, nombre, pwd, apellido,rol,peso);
    }

    public static boolean editarUsuario(String dni, String nuevoNombre ,String nuevoApellido, String pwd, int rol){
        return UserDao.actualizarUsuario(dni, nuevoNombre, nuevoApellido, pwd, rol);
    }


    public static boolean eliminarUsuario(String dni){
        return UserDao.eliminarUsuario(dni);
    }

    public static TreeSet<String > getNombresUsuarios() {
        return UserDao.getNombresUsuarios();
    }

    public static boolean sumarVictoria(int id) {
        return UserDao.sumarVictoria(id);
    }
}

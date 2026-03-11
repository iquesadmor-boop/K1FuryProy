package es.masanz.da.service;

import es.masanz.da.dao.LigaDao;
import es.masanz.da.dao.UserDao;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static es.masanz.da.config.Config.*;

public class UserService {


    public static boolean autenticar(String nombre, String pwd) {
        return UserDao.autenticar(nombre, pwd);
    }

    public static boolean crearUsuario(String dni, String nombre, String pwd, String apellido, int rol, int peso){
        return UserDao.insertarUsuario(dni, nombre, pwd, apellido,rol,peso);
    }

    public static List<String > getNombresUsuarios() {
        return UserDao.getNombresUsuarios();
    }
}

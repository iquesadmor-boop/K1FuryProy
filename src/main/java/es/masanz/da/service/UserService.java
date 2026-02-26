package es.masanz.da.service;

import es.masanz.da.dao.UserDao;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class UserService {


    public static boolean autenticar(String nombre, String pwd) {
        return UserDao.autenticar(nombre, pwd);
    }

}

package es.masanz.da.service;

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

    public List<String> getAccionesMenu(){
        return new ArrayList<>(List.of(
                    MENU_ACCION_GESTION_LIGA,
                    MENU_ACCION_GESTIONAR_USUARIOS,
                    MENU_ACCION_COMBATES,
                    MENU_ACCION_CLASIFICACION
        ));
    }
}

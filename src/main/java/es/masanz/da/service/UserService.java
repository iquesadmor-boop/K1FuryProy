package es.masanz.da.service;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class UserService {

    public static void autenticar(@NotNull Context context) {

        String nombre = context.formParam("nombre");
        String pwd = context.formParam("pwd");

        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put(nombre, pwd);


    }

}

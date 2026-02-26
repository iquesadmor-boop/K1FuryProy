package es.masanz.da.dao;

import es.masanz.da.model.Usuario;

import java.util.Map;

import static es.masanz.da.config.Config.*;

public class UserDao {

    private static Map<String, Usuario> usuarios = Map.of(
            "admin", new Usuario(1,"admin","admin","admin",ROL_ADMIN_ID,70),
            "otro", new Usuario(2,"otro","admin","admin",ROL_ADMIN_ID,70),
            "adm", new Usuario(3,"adm","","adm",ROL_ADMIN_ID,70)
    );

    public static boolean autenticar(String nombre, String pwd) {
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            if (entry.getKey().equals(nombre)){
                if (entry.getValue().getPassword().equalsIgnoreCase(pwd)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }


}

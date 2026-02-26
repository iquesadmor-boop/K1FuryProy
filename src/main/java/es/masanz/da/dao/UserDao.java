package es.masanz.da.dao;

import es.masanz.da.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static es.masanz.da.config.Config.*;

public class UserDao {
    private static Logger logger = LogManager.getLogger();


    private static Map<String, Usuario> usuarios = Map.of(
            "admin", new Usuario(1,"admin","admin","admin",ROL_ADMIN_ID,70),
            "otro", new Usuario(2,"otro","admin","admin",ROL_ADMIN_ID,70),
            "adm", new Usuario(3,"adm","","adm",ROL_ADMIN_ID,70)
    );

    public static boolean autenticar(String nombre, String pwd) {
        logger.info("Logeando con las credenciales User: " + nombre + " Password " + pwd);
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            if (entry.getKey().equals(nombre)){
                if (entry.getValue().getPassword().equalsIgnoreCase(pwd)){
                    logger.info("Ha ido bien");
                    return true;
                }
            }
        }
        return false;
    }


}

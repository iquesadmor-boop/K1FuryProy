package es.masanz.da;

import es.masanz.da.controller.MainController;
import es.masanz.da.controller.UserController;
import es.masanz.da.service.UserService;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.FileSessionDataStore;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION MODO WEB");

        Javalin app1 = Javalin.create(config -> {
            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(fileSessionHandler("session1")));
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4444);

        setJavalinAppRoutes(app1);

    }

    private static void setJavalinAppRoutes(Javalin app) {

        app.get("/", MainController::iniciar);
        app.get("/login", MainController::iniciar);
        app.get("/exit", MainController::iniciar);
        app.get("/error", MainController::iniciar);

        app.post("/autenticar", UserController::autenticar);

//        app.get("/adm/menu", AdmController::mostrarMenuAdm);
//        app.post("/adm/menu", AdmController::gestionarMenuAdm);
//
//        app.get("/adm/crear-torneo", AdmController::mostrarCrearTorneo);
//        app.post("/adm/crear-torneo", AdmController::gestionarCrearTorneo);

    }

    public static SessionHandler fileSessionHandler(String sessionName) {
        SessionHandler sessionHandler = new SessionHandler();
        SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
        sessionCache.setSessionDataStore(fileSessionDataStore());
        sessionHandler.setSessionCache(sessionCache);
        sessionHandler.setHttpOnly(true);
        // make additional changes to your SessionHandler here
        sessionHandler.setSessionCookie(sessionName);
        return sessionHandler;
    }

    private static FileSessionDataStore fileSessionDataStore() {
        FileSessionDataStore fileSessionDataStore = new FileSessionDataStore();
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        File storeDir = new File(baseDir, "javalin-session-store");
        //C:\Users\USUARIO\AppData\Local\Temp\javalin-session-store
        storeDir.mkdir();
        fileSessionDataStore.setStoreDir(storeDir);
        return fileSessionDataStore;
    }
}

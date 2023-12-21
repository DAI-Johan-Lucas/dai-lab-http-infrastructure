package server.API;

import io.javalin.*;
import io.javalin.plugin.bundled.CorsPluginConfig;
import server.API.data.PersonController;

public class Api {
    public static void main(String[] args) {
//        Javalin app = Javalin.create(config -> {
//            config.plugins.enableCors(cors -> {
//                cors.add(CorsPluginConfig::anyHost);
//            });
//        });
//        app.start(7000);

        Javalin app = Javalin.create().start(7000);
        PersonController userController = new PersonController();
        app.get("/api/persons", userController::getAll);
        app.get("/api/persons/{id}", userController::getOne);
        app.post("/api/persons/", userController::create);
        app.put("/api/persons/{id}", userController::update);
        app.delete("/api/persons/{id}", userController::delete);
    }
}

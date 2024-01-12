package server.API;

import io.javalin.*;
import server.API.data.PersonController;
import server.API.data.AddressController;

public class Api {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> config.plugins.enableCors(cors -> cors.add(it -> {
            it.anyHost();
            it.allowCredentials = true;
        })));
        app.start(80);

        PersonController userController = new PersonController();
        app.get("/api/persons", userController::getAll);
        app.get("/api/persons/{id}", userController::getOne);
        app.post("/api/persons", userController::create);
        app.patch("/api/persons/{id}", userController::update);
        app.delete("/api/persons/{id}", userController::delete);

        AddressController addressController = new AddressController();
        app.get("/api/addresses", addressController::getAll);
    }
}

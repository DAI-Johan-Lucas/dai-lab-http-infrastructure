package dai.server.API;

import dai.server.API.data.PersonController;
import io.javalin.*;

public class Api {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        PersonController userController = new PersonController();
        app.get("/api/persons", userController::getAll);
        app.get("/api/persons/{id}", userController::getOne);
        app.post("/api/persons/", userController::create);
        app.put("/api/persons/{id}", userController::update);
        app.delete("/api/persons/{id}", userController::delete);
    }
}

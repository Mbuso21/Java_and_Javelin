import io.javalin.Javalin;


public class CakesAPI {

    Javalin app = Javalin.create();

    public CakesAPI(int port) {

        app.start(port);

    }

    public void stop() {
        app.stop();
    }

    public void getCakesAPI() {
        this.app.get("/cakes", CakesController::getAllCakes);
    }

    public void getSpecialCakesAPI() {
        this.app.get("/cakes/:special", CakesController::getSpecialCake);
    }

    public void getCakeSearched() {
        this.app.get("/cake/*", CakesController::getCakeSearched);
    }

    public void postCakeAPI() {
        this.app.post("/input", CakesController::postCake);
    }

}

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        CakesAPI api = new CakesAPI(7777);
        api.getCakesAPI();
        api.getSpecialCakesAPI();
    }

}

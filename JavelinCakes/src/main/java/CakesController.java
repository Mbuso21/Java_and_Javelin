import io.javalin.http.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CakesController {

    static public String[] availableCakes = new String[]{"carrot cake", "chocolate cake", "cheesecake", "special Cake"};

//    static public ArrayList<String> availableCakes = new ArrayList<String>();

    public CakesController() {
//        availableCakes = new ArrayList<String>("carrot cake", "chocolate cake", "cheesecake","special Cake");
//        availableCakes.add("carrot cake");
//        availableCakes.add("chocolate cake");
//        availableCakes.add("cheesecake");
//        availableCakes.add("special Cake");
    }

    public static void getAllCakes(Context context) {

        context.json(availableCakes);

    }

    public static void getSpecialCake(Context context) {

        for (String cake : availableCakes) {
            if (cake.contains(context.pathParam("special"))) {
                context.result(cake);
                return;
            }
        }
        context.result("No Cake found");
    }

    public static void postCake(Context context) {

        context.json(availableCakes);
        context.status(201);

    }

    public static void getCakeSearched(Context context) {
        String caker = context.path();
        String[] cakerArray = caker.split("/");
        context.result(cakerArray.toString());

        for (String cake : availableCakes) {
            if (cake.contains(cakerArray[2])) {
                context.result(cake);
                return;
            }
        }
        context.result("No Cake found");
    }

}

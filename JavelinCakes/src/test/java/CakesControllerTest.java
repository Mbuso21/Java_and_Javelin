import io.javalin.Javalin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static org.junit.jupiter.api.Assertions.*;


class CakesControllerTest {

    @Test
    @DisplayName("GET/cakes")
    public void testGetAllCakes() {
        CakesAPI api = new CakesAPI(7777);
        api.getCakesAPI();
        HttpResponse<String> response = Unirest.get("http://localhost:7777/cakes").asString();
        assertEquals(200, response.getStatus());
        assertEquals("[\"carrot cake\",\"chocolate cake\",\"cheesecake\",\"special Cake\"]", response.getBody());
        api.stop();
    }

    @Test
    @DisplayName("GET/cakes/special")
    public void testGetSpecialCake() {
        CakesAPI api = new CakesAPI(7777);
        api.getSpecialCakesAPI();
        HttpResponse<String> response = Unirest.get("http://localhost:7777/cakes/special").asString();
        assertEquals(200, response.getStatus());
        assertEquals("special Cake", response.getBody());
        api.stop();
    }

    @Test
    @DisplayName("GET/body")
    public void testGetCakeSearched() {
        CakesAPI api = new CakesAPI(7777);
        api.getCakeSearched();
        HttpResponse<String> response = Unirest.get("http://localhost:7777/cake/carrot").asString();
        assertEquals(200, response.getStatus());
        assertEquals("carrot cake", response.getBody());
    }

    @Test
    @DisplayName("GET/body no found")
    public void testGetCakeSearchedNotFound() {
        CakesAPI api = new CakesAPI(7777);
        api.getCakeSearched();
        HttpResponse<String> response = Unirest.get("http://localhost:7777/cake/star").asString();
        assertEquals(200, response.getStatus());
        assertEquals("No Cake found", response.getBody());
    }

    @Test
    @DisplayName("POST/input")
    public void testPostCake() {
        CakesAPI api = new CakesAPI(7777);
        api.postCakeAPI();
        HttpResponse<String> response = Unirest.post("http://localhost:7777/input").
                body("money cake").asString();
        assertEquals(201, response.getStatus());
        assertEquals("[\"carrot cake\",\"chocolate cake\",\"cheesecake\",\"special Cake\",\"money Cake\"]",
                response.getBody());
        api.stop();
    }

}
package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;

/**
 * Created by Gebruiker on 28-7-2017.
 */
public class ApiTest {

    String driver = "max_verstappen";
    String season = "2016";

    @Test
    public void doGet() {
        given().when().get("http://ergast.com/api/f1/current/last/results").then().statusCode(200);


    }

    @Test
    public void checkverstappen() {
        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").then().body("MRData.RaceTable.driverId", containsString("max_verstappen"));
        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").then().body("MRData.RaceTable.driverId", containsString("max_verstappen")).and().body("MRData.RaceTable.Races[1].season", containsString("2016"));
        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").then().body("MRData.RaceTable.driverId", equalTo("max_verstappen"));
    }

    @Test
    public void testUrlParam(){
        given().pathParam("season", season).pathParam("driver", driver).when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").then().body("MRData.RaceTable.driverId", equalTo("max_verstappen"));
    }

}

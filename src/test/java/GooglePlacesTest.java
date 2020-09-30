import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class GooglePlacesTest extends TestConfig {

    @Test
    public void validateXmlSchema() {
    given()
            .log().uri()
            .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?key=AIzaSyBSkCi-" +
            "ezIUbYa3XrbmrlOUErt8BF6t_TU&input=New York&inputtype=textquery&fields=name,geometry&language=EN")
            .then()
            .body(matchesXsdInClasspath("xmlSchema.xsd"))
            .log().body();
    }

    @Test
    public void validateJsonSchema() {
        given()
                .log().uri()
                .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?key=AIzaSyBSkCi-" +
                "ezIUbYa3XrbmrlOUErt8BF6t_TU&input=New York&inputtype=textquery&fields=name,geometry&language=EN")
                .then()
                .body(matchesJsonSchemaInClasspath("jsonSchema.json"))
                .log().body();
    }
}

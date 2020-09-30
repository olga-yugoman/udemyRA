import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        given()
                .spec(requestSpecForSwapi)
                .log().uri()
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getSomeField() {
        given()
                .spec(requestSpecForSwapi)
                .log().uri()
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .body("name", equalTo("Luke Skywalker"))
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getAllData() {
        Response response =
        given()
                .spec(requestSpecForSwapi)
                .log().uri()
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .extract().response();

        String responseAsString = response.asString();
        System.out.println(responseAsString);
    }

    @Test
    public void getCookieResponse() {
        Response response =
                given()
                        .spec(requestSpecForSwapi)
                        .log().uri()
                        .when()
                        .get(SWAPI_GET_PEOPLE + "1")
                        .then()
                        .extract().response();

        Map<String, String> allCookie = response.getCookies();
        System.out.println("allCookie---->" + allCookie);
    }

    @Test
    public void getHeadersResponse() {
        Response response =
                given()
                        .spec(requestSpecForSwapi)
                        .log().uri()
                        .when()
                        .get(SWAPI_GET_PEOPLE + "1")
                        .then()
                        .extract().response();

        Headers headers = response.getHeaders();
        System.out.println("headers---->" + headers);

        String contentType = response.getContentType();
        System.out.println("contentType---->" + contentType);
    }

    @Test
    public void getMapOfElements() {
        Response response =
                given()
                        .spec(requestSpecForSwapi)
                        .log().uri()
                        .when()
                        .get(SWAPI_GET_PEOPLE);

        Map<String, ?> someObject= response
                .path("results.find {it.name = 'R2-D2'}");
        System.out.println(someObject);
    }

    @Test
    public void getSingleElement() {
        Response response =
                given()
                        .spec(requestSpecForSwapi)
                        .log().uri()
                        .when()
                        .get(SWAPI_GET_PEOPLE);

       String birthYear = response
                .path("results.find {it.name = 'R2-D2'}.birth_year");
        System.out.println(birthYear);
    }

    @Test
    public void getAllElementsWithSomeKey() {
        Response response =
                given()
                        .spec(requestSpecForSwapi)
                        .log().uri()
                        .when()
                        .get(SWAPI_GET_PEOPLE);

        List films = response
                .path("results.findAll {it.films}.name");
        System.out.println(films);
    }
}

import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceholderTest extends TestConfig {

    @Test
    public void get() {
        given()
                .queryParam("userId", 1)
                .log().uri()
                .when()
                .get(JP_GET)
                .then()
                .spec(responseSpecForGet)
                .log().body();
    }

    @Test
    public void put() {
        String putBodyJson = "{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";

        given()
                .body(putBodyJson)
                .log().uri()
                .when()
                .get(JP_PUT)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void delete() {
        given()
                .log().all()
                .when()
                .delete(JP_DELETE)
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void postJson() {
        String postJsonBody = "{\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";

        given()
                .body(postJsonBody)
                .log().all()
                .when()
                .post(JP_POST)
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void postXml() {
        String postXmlBody = "<?xml version=\"1.0\"?>\n" +
                "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Tanmay</FirstName>\n" +
                "      <LastName>Patil</LastName>\n" +
                "      <ContactNo>1234567890</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>";

        given()
                .spec(requestSpecXml)
                .body(postXmlBody)
                .log().all()
                .when()
                .post("")
                .then()
                .log().body()
                .statusCode(200);
    }
}

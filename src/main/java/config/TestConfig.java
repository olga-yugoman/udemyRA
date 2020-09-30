package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.*;

public class TestConfig {

    protected RequestSpecification requestSpecForSwapi = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .setBasePath(SWAPI_PATH)
            .build();

    protected RequestSpecification requestSpecXml = new RequestSpecBuilder()
            .addHeader("Content-type","application/xml")
            .addCookie("testCookieXML")
            .setBaseUri(REQUESTBIN_URL)
            .build();

    protected RequestSpecification requestSpecJson = new RequestSpecBuilder()
            .addHeader("Content-type","application/json")
            .addCookie("testCookie")
            .build();

    protected ResponseSpecification responseSpecForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    protected ResponseSpecification responseSpecForPost = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}

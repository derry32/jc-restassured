package com.juaracoding;

import com.juaracoding.utils.Constants;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MovieTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = Constants.BASE_URL;
    }

    @Test
    public void testNowPlaying() {
        given()
                .header("authorization", Constants.ACCESS_TOKEN)
                .queryParam("language", "en-us")
                .queryParam("page", "2")
                .when()
                .get("/movie/now_playing")
                .then()
                .statusCode(200)
                .body("results.title[0]", equalTo("The Mouse Trap"));



    }
}

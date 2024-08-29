package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {
//    String baseUrl = "https://reqres.in/api";

    @Test
    public void testValidLogin(){
        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        JSONObject requestBody = new JSONObject();
        requestBody.put("email","eve.holt@reqres.in");
        requestBody.put("password","cityslicka");
        System.out.println(requestBody.toJSONString());

        request.header("content-type", "application/json");
        request.body(requestBody.toJSONString());
        Response response = request.post("/login");

        String token = response.getBody().jsonPath().getString("token");
        System.out.println(token);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void testValidLoginBlogApi(){
        RestAssured.baseURI = "http://localhost:8081/api";
        RequestSpecification request = RestAssured.given();

        JSONObject requestBody = new JSONObject();
        requestBody.put("usernameOrEmail","leanne");
        requestBody.put("password","password");
        System.out.println(requestBody.toJSONString());

        request.header("content-type", "application/json");
        request.body(requestBody.toJSONString());
        Response response = request.post("/auth/signin");

        String token = response.getBody().jsonPath().getString("accessToken");
        System.out.println(token);
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}

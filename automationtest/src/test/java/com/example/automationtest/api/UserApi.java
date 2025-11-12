package com.example.automationtest.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi {

    // Method gửi GET request
    public Response getUsers(String endpoint) {
        String BASE_URL = "http://localhost:8089";
        return given()
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .extract()
                .response();
    }
}
package com.apiautomation.day_21June2024;

import io.restassured.RestAssured;

public class BasicRA1 {
    public static void main(String[] args) {

        // simple test case to check health of restful booker
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when()
                .get()
                .then()
                .statusCode(201);
    }
}

package com.apiautomation.testNG_day_22June2024;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestNGBasic1 {

    @Description("Positive test case to check ping health of restful booker")
    @Test
    public void pingCheckPositive(){
        // simple test case to check health of restful booker
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when()
                .get()
                .then()
                .statusCode(201);
        System.out.println("Restful booker ping health is 201 OK");
    }

    @Description("Negative test case to check ping health of restful booker")
    @Test
    public void pingCheckNegative(){
        // simple test case to check health of restful booker
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Description("This is a get request 1 for Restful booker")
    @Test
    public void getRequest1(){
        System.out.println("GET request 1");
    }

}

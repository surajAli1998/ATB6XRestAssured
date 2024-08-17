package com.apiautomation.testNG_day_23June2024.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DeleteBooking {
    static String BASE_URL = "https://restful-booker.herokuapp.com";
    static String BASE_PATH = "/booking";
    String bookingId = "1678";
    RequestSpecification rs = RestAssured.given().auth().preemptive().basic("admin","password123");
    Response response;
    ValidatableResponse responseValidate;

    @Test
    public void deleteBooking(){
        String newBasePath = BASE_PATH+"/"+bookingId;
        rs.baseUri(BASE_URL);
        rs.basePath(newBasePath);
        rs.contentType(ContentType.JSON);

        response = rs.when().log().all().delete();
        String stringResponse =  response.asString();
        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(201);
    }

}

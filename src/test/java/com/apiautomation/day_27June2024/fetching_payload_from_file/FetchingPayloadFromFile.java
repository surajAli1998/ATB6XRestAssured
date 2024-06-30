package com.apiautomation.day_27June2024.fetching_payload_from_file;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class FetchingPayloadFromFile {
    static String BASE_URL = "https://restful-booker.herokuapp.com";
    static String BASE_PATH = "/booking";
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse responseValidate;

    @Test
    public void createBookingTest2(){
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON);
        File file = new File("src/test/resources/bookingData.json");
        rs.body(file);

        response = rs.when().log().all().post();
        String stringResponse =  response.asString();
        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(200);
    }
}

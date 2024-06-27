package com.apiautomation.testNG_day_23June2024.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateBookingNonBDD {

    static String BASE_URL = "https://restful-booker.herokuapp.com";
    static String BASE_PATH = "/booking";
    String payload = "{\n" +
            "    \"firstname\" : \"Suraj\",\n" +
            "    \"lastname\" : \"Ali\",\n" +
            "    \"totalprice\" : 4672,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-01-12\",\n" +
            "        \"checkout\" : \"2023-06-12\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Dinner\"\n" +
            "}";
    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse responseValidate;

    @Test
    public void createBookingNonBdd(){
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        response = rs.when().log().all().post();
        String stringResponse =  response.asString();
        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(200);
    }

    @Test
    public void createBookingNonBddNegative(){
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON);
        rs.body("");

        response = rs.when().log().all().post();
        String stringResponse =  response.asString();
        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(200);
    }

}

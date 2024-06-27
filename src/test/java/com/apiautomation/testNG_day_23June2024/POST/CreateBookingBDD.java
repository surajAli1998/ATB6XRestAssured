package com.apiautomation.testNG_day_23June2024.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateBookingBDD {
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
    @Test
    public void createBookingBDD(){
        RestAssured.given()
                .baseUri(BASE_URL)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .when().post()
                .then().log().all()
                .statusCode(200);
    }
}

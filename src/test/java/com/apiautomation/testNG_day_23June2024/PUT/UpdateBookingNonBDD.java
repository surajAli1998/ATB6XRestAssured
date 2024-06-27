package com.apiautomation.testNG_day_23June2024.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UpdateBookingNonBDD {
    static String BASE_URL = "https://restful-booker.herokuapp.com";
    static String BASE_PATH = "/booking";
    String bookingId = "1926";
    String token = "4fb7dda90803bde";
    String payload = "{\n" +
            "    \"firstname\" : \"Souvik\",\n" +
            "    \"lastname\" : \"Karar\",\n" +
            "    \"totalprice\" : 5000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-05-12\",\n" +
            "        \"checkout\" : \"2023-06-12\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    RequestSpecification rs = RestAssured.given().auth().preemptive().basic("admin","password123");
    Response response;
    ValidatableResponse responseValidate;

    @Test
    public void updateBookingFully(){
        String newBasePath = BASE_PATH+"/"+bookingId;
        rs.baseUri(BASE_URL);
        rs.basePath(newBasePath);
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        response = rs.when().log().all().put();
        String stringResponse =  response.asString();
        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(200);
        responseValidate.body("firstname", Matchers.equalTo("Souvik"));
        responseValidate.body("lastname", Matchers.equalTo("Karar"));
    }


}

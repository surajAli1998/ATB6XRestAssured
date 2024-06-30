package com.apiautomation.day_27June2024.gson.serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateBooking {
    static String BASE_URL = "https://restful-booker.herokuapp.com";
    static String BASE_PATH = "/booking";

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse responseValidate;

    @Test
    public void createBookingTest(){

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-01-12");
        bookingDates.setCheckout("2023-06-12");

        BookingData bookingData = new BookingData();
        bookingData.setFirstname("Suraj");
        bookingData.setLastname("Ali");
        bookingData.setTotalPrice(1235);
        bookingData.setDepositpaid(true);
        bookingData.setBookingDates(bookingDates);
        bookingData.setAdditionalneeds("Biryani");

//        System.out.println(bookingData);

        Gson gson = new Gson();
        String jsonPayload = gson.toJson(bookingData);
//        System.out.println(jsonPayload);

        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON);
        rs.body(jsonPayload);

        response = rs.when().log().all().post();
        String stringResponse =  response.asString();
//        System.out.println(stringResponse);

        responseValidate = response.then().log().all();
        responseValidate.statusCode(200);
    }

}

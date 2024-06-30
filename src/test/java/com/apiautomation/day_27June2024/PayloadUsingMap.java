package com.apiautomation.day_27June2024;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PayloadUsingMap {

    @Test
    public void createOrderTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        Integer bookingId;

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        Map<String,Object> payloadMap = new LinkedHashMap<>();

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Integer totalPrice = faker.random().nextInt(1000);
        Boolean depositPaid = faker.random().nextBoolean();
        String additionalNeeds = faker.food().dish();

        Map<String,Object> bookingDates = new LinkedHashMap<>();
        bookingDates.put("checkin","2023-01-12");
        bookingDates.put("checkout","2023-02-12");

        payloadMap.put("firstname",firstName);
        payloadMap.put("lastname",lastName);
        payloadMap.put("totalprice",totalPrice);
        payloadMap.put("depositpaid",depositPaid);
        payloadMap.put("bookingdates",bookingDates);
        payloadMap.put("additionalneeds",additionalNeeds);

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadMap);

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}

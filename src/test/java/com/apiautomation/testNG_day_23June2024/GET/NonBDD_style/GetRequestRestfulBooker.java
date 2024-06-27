package com.apiautomation.testNG_day_23June2024.GET.NonBDD_style;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequestRestfulBooker {

    RequestSpecification rs = RestAssured.given();
    @Test
    public void getSingleBooking(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/842");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

    @Test
    public void getSingleBookingNegative(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/d");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(404);
    }
}

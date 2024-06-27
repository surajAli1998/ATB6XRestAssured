package com.apiautomation.testNG_day_23June2024.GET.NonBDD_style;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetNonBDD1 {

    RequestSpecification rs = RestAssured.given();

    @Test
    public void getAddressWithZipcodeNonBddRequest1(){
        rs.baseUri("https://api.zippopotam.us/");
        rs.basePath("/IN/700045");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

    @Test
    public void getAddressWithZipcodeNonBddRequest2(){
        rs.baseUri("https://api.zippopotam.us/");
        rs.basePath("/IN/700047");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);
    }

}

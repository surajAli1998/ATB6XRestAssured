package com.apiautomation.testNG_day_23June2024.GET.BDD_style;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBDD1 {
    @Test
    public void getAddressWithZipcodeBDD(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/700045")
                .when().log().all().get()
                .then()
                .log().all()
                .statusCode(200);
    }
}

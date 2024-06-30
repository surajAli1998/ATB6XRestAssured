package com.apiautomation.day_27June2024.json_schema_validation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class JsonSchemaValidation {
    @Test
    public void validateResponseSchemaTest(){
        RestAssured.given().baseUri("https://jsonplaceholder.typicode.com").basePath("/posts/1")
                .when().get().then()
                .log().all()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src\\test\\resources\\schema.json")));
    }
}

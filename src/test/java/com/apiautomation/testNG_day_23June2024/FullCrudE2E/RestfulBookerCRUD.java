package com.apiautomation.testNG_day_23June2024.FullCrudE2E;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class RestfulBookerCRUD {

    RequestSpecification requestSpecification = RestAssured.given().auth().preemptive().basic("admin","password123");
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    public String getToken(){
        String token;
        String baseURI = "https://restful-booker.herokuapp.com";
        String basePath = "/auth";
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri(baseURI);
        requestSpecification.basePath(basePath);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        token = validatableResponse.extract().path("token");
        Assert.assertNotNull(token);

        return token;
    }

    @BeforeTest
    public Integer getBookingId(){
        Integer bookingId;
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
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

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = validatableResponse.extract().path("bookingid");
        Assert.assertNotNull(bookingId);

        return bookingId;
    }

    @Test
    public void fullUpdateBooking(){
        Integer bookingId = getBookingId();
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String newBasePath = BASE_PATH+"/"+bookingId;
        String token = getToken();
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
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(newBasePath);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().log().all().put();
        String fullResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // verifying response using Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Souvik"));

        // verifying response using Basic TestNG assertion
        String firstName = validatableResponse.extract().path("firstname");
        Assert.assertEquals(firstName,"Souvik");

        // verifying response with TestNG assertion with JSON path library
        JsonPath jsonPath = new JsonPath(fullResponseString);
        String actualFirstName = jsonPath.getString("firstname");
        Integer actualTotalPrice = jsonPath.getInt("totalprice");
        Assert.assertEquals(actualFirstName,"Souvik");

        // verifying response using assertj library
        assertThat(actualFirstName).isEqualTo("Souvik").isNotEmpty();
        assertThat(actualTotalPrice).isNotZero();

    }

    @Test
    public void deleteBooking(){
        Integer bookingId = getBookingId();
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String newBasePath = BASE_PATH+"/"+bookingId;
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(newBasePath);
        requestSpecification.contentType(ContentType.JSON);

        response = requestSpecification.when().log().all().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }

}

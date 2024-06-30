package com.apiautomation.day_27June2024.gson.deserialization;

import com.apiautomation.day_27June2024.gson.serialization.BookingData;
import com.apiautomation.day_27June2024.gson.serialization.BookingResponse;
import com.google.gson.Gson;
import org.testng.annotations.Test;

public class Deserialization {
    @Test
    public void validateResponseTest(){
        String response = "{\n" +
                "    \"bookingid\": 1766,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Suraj\",\n" +
                "        \"lastname\": \"Ali\",\n" +
                "        \"totalprice\": 1235,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2023-01-12\",\n" +
                "            \"checkout\": \"2023-06-12\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Biryani\"\n" +
                "    }\n" +
                "}";

        Gson gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(response,BookingResponse.class);
        System.out.println("Booking id is: "+ bookingResponse.getBookingid());
    }

}

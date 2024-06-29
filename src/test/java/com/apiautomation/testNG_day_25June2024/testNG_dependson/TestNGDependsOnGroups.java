package com.apiautomation.testNG_day_25June2024.testNG_dependson;

import org.testng.annotations.Test;

public class TestNGDependsOnGroups {
    @Test(groups = {"init"})
    public void getToken(){
        System.out.println("Token");
    }

    @Test(groups = {"init"})
    public void getBookingId(){
        System.out.println("Booking ID");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void putRequest(){
        System.out.println("PUT request");
    }
}

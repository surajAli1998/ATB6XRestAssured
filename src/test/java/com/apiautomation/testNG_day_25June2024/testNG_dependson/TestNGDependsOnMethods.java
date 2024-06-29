package com.apiautomation.testNG_day_25June2024.testNG_dependson;

import org.testng.annotations.Test;

public class TestNGDependsOnMethods {
    @Test
    public void smokeTest1(){
        System.out.println("Smoke Test");
    }

    @Test(dependsOnMethods = {"smokeTest1"})
    public void Case1(){
        System.out.println("Test Case 1");
    }
}

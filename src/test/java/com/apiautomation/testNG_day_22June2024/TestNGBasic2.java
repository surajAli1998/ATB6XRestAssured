package com.apiautomation.testNG_day_22June2024;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestNGBasic2 {
    @Description("Test Method 1")
    @Test
    public void testMethod1(){
        System.out.println("Test method 1");
    }

    @Description("Test Method 2")
    @Test
    public void testMethod2(){
        System.out.println("Test method 2");
    }

    @Description("Test Method 3")
    @Test(enabled = false)
    public void testMethod3(){
        System.out.println("Test method 3");
    }

}

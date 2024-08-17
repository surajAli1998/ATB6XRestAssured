package com.apiautomation.testNG_day_22June2024;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {
    @Test
    public void case1(){
        SoftAssert soft = new SoftAssert();
        soft.assertEquals("suraj","suraj","Not equal");
        soft.assertAll();
        System.out.println("End of test case 1");

    }

    @Test
    public void case2(){
        Assert.assertEquals("suraj","suraj","Not equal");
        System.out.println("End of test case 2");
    }
}

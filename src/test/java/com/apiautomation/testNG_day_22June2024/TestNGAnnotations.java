package com.apiautomation.testNG_day_22June2024;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void method1(){
        System.out.println("Before Suite");
    }

    @Test
    public void TestCase1(){
        System.out.println("Test case");
    }

    @BeforeClass
    public void method3(){
        System.out.println("Before Class");
    }

    @BeforeTest
    public void method2(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void method4(){
        System.out.println("Before Method");
    }


    @AfterMethod
    public void method6(){
        System.out.println("After Method");
    }

    @AfterSuite
    public void method9(){
        System.out.println("After Suite");
    }

    @AfterClass
    public void method7(){
        System.out.println("After Class");
    }

    @AfterTest
    public void method8(){
        System.out.println("After Test");
    }

}

package com.apiautomation.testNG_day_23June2024;

import org.testng.annotations.*;

public class Demo2 {
    @BeforeSuite
    public void demo2BeforeSuite(){
        System.out.println("demo2BeforeSuite");
    }

    @Test
    public void demo2TestCase(){
        System.out.println("demo2TestCase");
    }

    @BeforeClass
    public void demo2BeforeClass(){
        System.out.println("demo2BeforeClass");
    }

    @BeforeTest
    public void demo2BeforeTest(){
        System.out.println("demo2BeforeTest");
    }

    @BeforeMethod
    public void demo2BeforeMethod(){
        System.out.println("demo2BeforeMethod");
    }

    @AfterMethod
    public void demo2AfterMethod(){
        System.out.println("demo2AfterMethod");
    }

    @AfterSuite
    public void demo2AfterSuite(){
        System.out.println("demo2AfterSuite");
    }
    @AfterClass
    public void demo2AfterClass(){
        System.out.println("demo2AfterClass");
    }

    @AfterTest
    public void demo2AfterTest(){
        System.out.println("demo2AfterTest");
    }
}

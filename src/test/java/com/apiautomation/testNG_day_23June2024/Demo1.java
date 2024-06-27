package com.apiautomation.testNG_day_23June2024;

import org.testng.annotations.*;

public class Demo1 {
    @BeforeSuite
    public void demo1BeforeSuite(){
        System.out.println("demo1BeforeSuite");
    }

    @Test
    public void demo1TestCase(){
        System.out.println("demo1TestCase");
    }

    @BeforeClass
    public void demo1BeforeClass(){
        System.out.println("demo1BeforeClass");
    }

    @BeforeTest
    public void demo1BeforeTest(){
        System.out.println("demo1BeforeTest");
    }

    @BeforeMethod
    public void demo1BeforeMethod(){
        System.out.println("demo1BeforeMethod");
    }

    @AfterMethod
    public void demo1AfterMethod(){
        System.out.println("demo1AfterMethod");
    }

    @AfterSuite
    public void demo1AfterSuite(){
        System.out.println("demo1AfterSuite");
    }

    @AfterClass
    public void demo1AfterClass(){
        System.out.println("demo1AfterClass");
    }

    @AfterTest
    public void demo1AfterTest(){
        System.out.println("demo1AfterTest");
    }
}

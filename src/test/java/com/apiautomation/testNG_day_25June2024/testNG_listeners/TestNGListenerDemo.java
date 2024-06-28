package com.apiautomation.testNG_day_25June2024.testNG_listeners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TestNGListenerDemo {
    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @AfterSuite
    public void sendEmailNotification(){
        System.out.println("Sending Email...");
    }

}

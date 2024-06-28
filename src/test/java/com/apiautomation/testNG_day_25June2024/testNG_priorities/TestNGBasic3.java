package com.apiautomation.testNG_day_25June2024.testNG_priorities;

import org.testng.annotations.Test;

/**
 * 0 has the default priority.
 * negative has the more priority
 * example: -2 > -1 > 0 > 1 > 2
 */

public class TestNGBasic3 {

    @Test(priority = 2)
    public void testCase0(){
        System.out.println("Test case 0");
    }

    @Test(priority = 3)
    public void testCase1(){
        System.out.println("Test case 1");
    }

    @Test(priority = 0)
    public void testCase2(){
        System.out.println("Test case 2");
    }

    @Test(priority = -1)
    public void testCase3(){
        System.out.println("Test case 3");
    }

    @Test(priority = -2)
    public void testCase4(){
        System.out.println("Test case 4");
    }

    @Test(priority = -2)
    public void testCase5(){
        System.out.println("Test case 5");
    }

}

package com.apiautomation.testNG_day_25June2024.testNG_parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterisationWithDataProvider {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin","admin"},
                new Object[]{"admin","password123"},
                new Object[]{"admin","password234"}
        };
    }

    @Test(dataProvider = "getData")
    public void testCase1(String userName, String passWord){
        System.out.println("Username is "+userName);
        System.out.println("Password is "+passWord);
    }

}

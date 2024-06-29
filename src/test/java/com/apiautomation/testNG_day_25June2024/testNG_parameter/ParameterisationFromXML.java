package com.apiautomation.testNG_day_25June2024.testNG_parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisationFromXML {

    @Parameters({"username","password"})
    @Test
    public void testCase1(String userName, String passWord){
        System.out.println("Username is "+userName);
        System.out.println("Password is "+passWord);
    }

}

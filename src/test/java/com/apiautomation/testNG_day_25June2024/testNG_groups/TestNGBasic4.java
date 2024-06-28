package com.apiautomation.testNG_day_25June2024.testNG_groups;

import org.testng.annotations.Test;

/**
 * 1) We can group multiple test methods in a single group.
 * 2) In the testng xml file if we only include a particular group then only those test cases will
 *    run which comes under that group
 * 3) One test case can be part of multiple groups. In that case any one of the group needs to be
 *    included in the testng xml to run that test case.
 * 4) In case we use priority with groups then there are 2 cases:
 *          case A -> if only one group is included then, test cases under that group will follow
 *                    the priority normally
 *
 *          case B -> if multiple groups are included then, test cases will run on basis of priority
 */

public class TestNGBasic4 {
    @Test(groups = {"smokeTest"}, priority = 2)
    public void testCase0(){
        System.out.println("Test case 0");
    }

    @Test(groups = {"smokeTest"}, priority = 3)
    public void testCase1(){
        System.out.println("Test case 1");
    }

    @Test(groups = {"sanityTest"})
    public void testCase2(){
        System.out.println("Test case 2");
    }

    @Test(groups = {"sanityTest"})
    public void testCase3(){
        System.out.println("Test case 3");
    }

    @Test(groups = {"regressionTest","sanityTest"}, priority = 1)
    public void testCase4(){
        System.out.println("Test case 4");
    }

    @Test(groups = {"regressionTest","smokeTest"}, priority = 3)
    public void testCase5(){
        System.out.println("Test case 5");
    }

}

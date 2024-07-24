package com.apiautomation.testNG_misc_concepts.parallelrun;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelRunner2 {
    @BeforeMethod
    public void beforeMethodPR2() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod1PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod2PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod3PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod4PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod5PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @Test
    public void testMethod6PR2(){
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method. Thread id is: " + id + getClass().getSimpleName());
    }
    @AfterMethod
    public void afterMethodPR2() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id + getClass().getSimpleName());
    }

}

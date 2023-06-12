package com.cydeo.tests.day_05;

import org.testng.annotations.*;

public class TestNGIntro {

    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("after class");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
}

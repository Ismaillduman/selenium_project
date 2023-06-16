package com.cydeo.tests.day_09_java_faker;

import org.testng.annotations.Test;

public class SingletonPractice {
    @Test
    public void test(){
        Singleton.getWord();
    }
    @Test
    public void test2(){
        Singleton.getWord();
    }
    @Test
    public void test3(){
        Singleton.getWord();
    }

}

package com.cydeo.tests.day_09_java_faker;

public class Singleton {
    private  Singleton() {
    }
    private static String word;

    public static String getWord(){
        if(word==null){
            System.out.println("First time call. Driver object is null.");
            System.out.println("Assigning value to it now ");
            word="\"driver_adsf9876asdf9876asdf9876";
        }else{
            System.out.println("Driver already has a value");
        }
        return word;
    }
}

package com.cydeo.tests.day_09_java_faker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker= new Faker();
        System.out.println(faker.name().name());
        System.out.println(faker.numerify("####-####"));
        System.out.println("faker.phoneNumber() = " + faker.phoneNumber().phoneNumber());
        System.out.println(faker.bothify("??##??-??#?????", true));
        System.out.println(faker.letterify("????-???????", true));
        System.out.println(faker.numerify("##-####"));


    }
}

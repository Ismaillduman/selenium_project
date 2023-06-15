package com.cydeo.tests.day_08webTablesCont_properties_configReader;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void properties(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
    }
}

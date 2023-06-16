package com.cydeo.tests.day_08webTablesCont_properties_configReader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_test() throws IOException {

        //STEPS TO READ FROM PROPERTIES TYPE OF FILE
        //1 create object of properties
        Properties properties= new Properties();
        //2 We need to open the file in the java memory
        FileInputStream file= new FileInputStream("configurations.properties");
        //3 Load properties file in the properties object
        properties.load(file);
        //4 use the "properties" object to read value from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));

    }
}

package com.cydeo.tests.review.week_4;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Base {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("webTable.url"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}

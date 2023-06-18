package com.cydeo.tests.review.week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TC3_Registration {
    /*// TC#3: Registration Form Page Testing

    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"*/
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/registration_form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public  void registration() {

        String actual_title= driver.getTitle();
        String expected_title="Registration Form";
        Assert.assertEquals(actual_title,expected_title,"Expected Text not equal with the actual Text!!!");
        Assert.assertTrue(actual_title.equals(expected_title),"Expected Text not equal with the actual Text!!!");
        driver.quit();

    }
}

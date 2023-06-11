package com.cydeo.tests.review.week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC3_Registration {
    /*// TC#3: Registration Form Page Testing

    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"*/
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome","https://practice.cydeo.com/registration_form");
        String actual_title= driver.getTitle();
        String expected_title="Registration Form";
        Assert.assertEquals(actual_title,expected_title,"Expected Text not equal with the actual Text!!!");
    }
}

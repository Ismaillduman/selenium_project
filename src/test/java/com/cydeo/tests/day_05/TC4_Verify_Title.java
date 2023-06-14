package com.cydeo.tests.day_05;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC4_Verify_Title {
    /*C #4: Cydeo Title Verification
1.Open Chrome browser
2.Go to https://www.cydeo.com
3.Verify title:
Expected: Cydeo*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://www.cydeo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verify_title() {
        String actual_title = driver.getTitle();
        String expected_title="Cydeo";
        Assert.assertEquals(actual_title,expected_title,"Actual title and expected title is not equal");
    }
}

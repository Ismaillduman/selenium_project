package com.cydeo.tests.day_11;

import com.cydeo.Pages.DynamicallyLoadedPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicallyLoaded {
    DynamicallyLoadedPage dynamically;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        
        dynamically = new DynamicallyLoadedPage();

    }

    /*TC#10 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.
Note: Follow POM*/
    @Test
    public void wait_until_title() {

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        String actual_text = dynamically.alertText.getText();
        String expected_text = "Done!";

        Assert.assertEquals(actual_text, expected_text);

        Assert.assertTrue(dynamically.image.isDisplayed());


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

package com.cydeo.tests.day_05;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC5_dropDownAndStateSelection {
    /*TC#5: Verifying “Simple dropdown” and “State selection” dropdown
default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dropDown() {
        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(driver.findElement(By.cssSelector("#dropdown")));
        //String actualText= dropDown.getText();
        String actualText = select.getFirstSelectedOption().getText();
        //System.out.println("some = " + actualText);

        String expected_text = "Please select an option";
        Assert.assertEquals(actualText, expected_text);
        WebElement state = driver.findElement(By.id("state"));
        Select selectState = new Select(driver.findElement(By.id("state")));
        String actual_default_select_state = selectState.getFirstSelectedOption().getText();
        String expected_default_selected_state = "Select a State";
        Assert.assertEquals(actual_default_select_state, expected_default_selected_state);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

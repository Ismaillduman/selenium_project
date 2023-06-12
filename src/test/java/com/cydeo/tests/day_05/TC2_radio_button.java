package com.cydeo.tests.day_05;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS*/
public class TC2_radio_button {
    WebDriver driver;
@BeforeMethod
    public void setUp(){
    driver = WebDriverFactory.getDriver("chrome","https://practice.cydeo.com/radio_buttons");
}
@Test
    public void radio_button(){
    WebElement hockey=driver.findElement(By.cssSelector("#hockey"));
    hockey.click();
    Assert.assertTrue(hockey.isSelected(),"hockey radio button is not selected");


}
}

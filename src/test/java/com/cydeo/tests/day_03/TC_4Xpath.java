package com.cydeo.tests.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TC_4Xpath {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/");
        WebElement login_text= driver.findElement(By.xpath("//input[@value='Log In']"));
        String expected="Log In";
        String actual=login_text.getAttribute("value");
        Assert.assertEquals(actual,expected);
        //driver.quit();
    }
}

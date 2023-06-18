package com.cydeo.tests.office_hours.week_1;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001 {

    /*C001 As a user I should be able to see Login label is displayed

1-open a chrome browser
2-goto https://vytrack.com/
3-verify Login is displayed*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://vytrack.com/");
        BrowserUtils.sleep(3);
    }
    @Test
    public  void verifyLogin(){
        WebElement loginText=driver.findElement(By.xpath("(//a[@href='http://app.vytrack.com'])[1]"));
        Assert.assertTrue(loginText.isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

package com.cydeo.tests.office_hours.week_1;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TC002 {
    /* TC002 As a user I should be able to see the login page

     1- Setup the "browser driver"
     2- Go to "https://vytrack.com"
     3- Click Login label
     3- Verify the title contains "Login"*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome","https://vytrack.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public  void verifyLogin(){
        WebElement loginText=driver.findElement(By.xpath("(//a[@href='http://app.vytrack.com'])[1]"));
        loginText.click();
        String actual_title= driver.getTitle();

        Assert.assertTrue(actual_title.contains("Login"));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

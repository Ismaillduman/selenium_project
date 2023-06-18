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

import java.time.Duration;

public class TC003 {
    /* ** TC003 As a user I should be able to login with valid credentials

 1- Setup the "browser driver"
 2- Go to "https://vytrack.com"
 3- Click Login label
 4- Login to application with username as "User1" and password as "UserUser123"
 5- Verify the title contains "Dashboard"*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://vytrack.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyLogin() throws InterruptedException {

        WebElement loginText = driver.findElement(By.xpath("(//a[@href='http://app.vytrack.com'])[1]"));

        loginText.click();
        String actual_title = driver.getTitle();
        Assert.assertTrue(actual_title.contains("Login"));
        WebElement username_box = driver.findElement(By.cssSelector("#prependedInput"));
        WebElement password_box = driver.findElement(By.cssSelector("#prependedInput2"));
        WebElement login_button = driver.findElement(By.cssSelector("#_submit"));
        username_box.sendKeys("User1");
        password_box.sendKeys("UserUser123");
        login_button.click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());


        BrowserUtils.verifyTitleContains("Dashboard", driver);


    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}

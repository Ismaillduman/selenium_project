package com.cydeo.tests.day_07_WebTables;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Window {
    /*TC #1: Window Handle practice
1. Create new test and make set ups
2. Go to : https://www.amazon.com
3. Copy paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”
Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void windowHandle() {
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

//        Set<String> windowsHandel = driver.getWindowHandles();
//        for (String eachWindow : windowsHandel) {
//            driver.switchTo().window(eachWindow);
//            if (driver.getCurrentUrl().contains("etsy")) {
//                break;
//            }
//        }
//        String actualTitle = driver.getTitle();
//        String expectedTitleContains = "Etsy";
//        Assert.assertTrue(actualTitle.contains(expectedTitleContains));


        BrowserUtils.switchWindowAndVerify(driver,"etsy","etsy");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

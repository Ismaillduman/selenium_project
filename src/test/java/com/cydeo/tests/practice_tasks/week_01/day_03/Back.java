package com.cydeo.tests.practice_tasks.week_01.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Back {
    public static void main(String[] args) {
        /* Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google*/
        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://google.com");
        driver.findElement(By.xpath("//button[@id='W0wltc']")).click();
        WebElement gmail = driver.findElement(By.xpath("//*[@aria-label='Gmail (Öffnet einen neuen Tab.)']"));
        gmail.click();
        String actual = driver.getTitle();
        String expected = "Gmail";
        Assert.assertEquals(actual, expected);
        driver.navigate().back();
        String actual_home = driver.getTitle();
        String expected_home = "Google";
        Assert.assertEquals(actual_home, expected_home);
        driver.quit();
    }
}

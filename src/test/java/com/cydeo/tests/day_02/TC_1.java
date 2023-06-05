package com.cydeo.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(1000);
        String expectedUrl = "https://practice.cydeo.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle, expectedTitle,"Actual URL doesn't match the expected URL.");

        driver.quit();
    }
}

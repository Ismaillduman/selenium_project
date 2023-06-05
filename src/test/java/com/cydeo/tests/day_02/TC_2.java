package com.cydeo.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com");
        // Thread.sleep(1000);
        // driver.findElement(By.xpath("//a[normalize-space()='A/B Testing']")).click();
        driver.findElement(By.linkText("A/B Testing")).click();
        String currentTitleAbTest = driver.getTitle();
        String expectedTitleABTest = "No A/B Test";
        Assert.assertEquals(currentTitleAbTest, expectedTitleABTest);
        // Thread.sleep(1000);
        driver.navigate().back();
        // Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        Assert.assertEquals(actualTitle, expectedTitle);



    }
}

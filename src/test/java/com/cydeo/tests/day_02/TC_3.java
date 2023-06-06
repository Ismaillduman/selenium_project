package com.cydeo.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();
        //driver.findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Apple");
        searchBox.sendKeys(Keys.ENTER);
        //searchBox.submit();
        String currentTitle = driver.getTitle();
        String expectedTitle = "Apple - Google Suche";
        Assert.assertEquals(currentTitle, expectedTitle, "Try again that's not correct Title");
        driver.quit();
    }
}

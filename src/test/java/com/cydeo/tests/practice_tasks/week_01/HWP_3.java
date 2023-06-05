package com.cydeo.tests.practice_tasks.week_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HWP_3 {
    public static void main(String[] args) {
        /*TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google*/
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();
        WebElement gmail= driver.findElement(By.linkText("Gmail"));
        gmail.click();
        String actualTitle= driver.getTitle();
        String expectedTitle= "Gmail";
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.navigate().back();
        String actualTitle2= driver.getTitle();
        String expectedTitle2= "Google";
        Assert.assertEquals(actualTitle2,expectedTitle2);
driver.quit();

    }
}

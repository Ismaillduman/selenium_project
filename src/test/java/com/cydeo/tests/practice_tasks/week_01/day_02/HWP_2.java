package com.cydeo.tests.practice_tasks.week_01.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HWP_2 {
    public static void main(String[] args) {
        /*: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”*/

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement header= driver.findElement(By.className("page-header"));
        String actualHeader= header.getText();
        String expectedHeader= "Log in to ZeroBank";
        Assert.assertEquals(actualHeader,expectedHeader);
driver.quit();
    }
}

package com.cydeo.tests.practice_tasks.week_01.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HWP_4 {
    public static void main(String[] args) {
        /*TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected: Expected: Practice
PS: Locate “Home” link using “className” locator*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://practice.cydeo.com/inputs");
        WebElement home= driver.findElement(By.className("nav-link"));
        home.click();
        String currentTitle=driver.getTitle();
        String expectedTitle= "Practice";
        Assert.assertEquals(currentTitle,expectedTitle);
        driver.quit();

    }
}

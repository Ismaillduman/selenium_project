package com.cydeo.tests.practice_tasks.week_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HWP_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        /*1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy*/
        driver.get("https://www.etsy.com");
        WebElement cookies=driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));
        Thread.sleep(2000);
        cookies.click();
        WebElement searchBox= driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        String actualTitle=driver.getTitle();
        String expectedTitle= "Wooden spoon - Etsy DE";
        Assert.assertEquals(actualTitle,expectedTitle);
driver.quit();
    }
}

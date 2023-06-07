package com.cydeo.tests.practice_tasks.week_01.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Etsy {
    /* Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”*/
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://www.etsy.com");
        driver.findElement(By.cssSelector("button[data-gdpr-single-choice-accept='true']")).click();
        WebElement search_box = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        search_box.sendKeys("spoon wooden" + Keys.ENTER);

        String actual_title = driver.getTitle();
        String expected_title = "Spoon wooden - Etsy DE";
        Assert.assertEquals(actual_title, expected_title);
        driver.quit();

    }
}

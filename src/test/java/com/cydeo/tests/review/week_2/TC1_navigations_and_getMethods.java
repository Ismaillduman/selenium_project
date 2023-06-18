package com.cydeo.tests.review.week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TC1_navigations_and_getMethods {
    /*// TC#1: Navigations and Get methods Practice

      // 1. Open a chrome browser
      // 2. Go to: https://www.etsy.com
      // 3. Navigate to https://www.amazon.com/
      // 4. Navigate back, forward and refresh
      // 5. Write “selenium” in search box
      // 6. Press search button to search
      // 7. Verify title is "Amazon.com : selenium"
      // 8. Verify url contains "selenium"*/
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        WebElement search_box= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement search_box2= driver.findElement(By.xpath("//label[.='Suche Amazon']"));
        //search_box.sendKeys("selenium"+ Keys.ENTER);
        search_box.sendKeys("selenium");
        WebElement search_button= driver.findElement(By.id("nav-search-submit-button"));
        search_button.click();
        String current_title= driver.getTitle();
        String expected_title="Amazon.com : selenium";
        Assert.assertEquals(current_title,expected_title);
        String actual_url=driver.getCurrentUrl();
        boolean isContains=actual_url.contains("selenium");
        Assert.assertTrue("Actual url not contains selenium",isContains);
        driver.quit();
    }
}

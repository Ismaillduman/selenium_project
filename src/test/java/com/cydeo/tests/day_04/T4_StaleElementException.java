package com.cydeo.tests.day_04;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementException {
    /*TC #4: StaleElementReferenceException Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate “CYDEO” link, verify it is displayed.
4- Refresh the page.
5- Verify it is displayed, again.
*/
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get( "https://practice.cydeo.com/abtest");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement cydeo = driver.findElement(By.xpath("//div//a"));
        driver.navigate().refresh();

      try {
          Assert.assertTrue("is displayed ", cydeo.isDisplayed());
      }catch (StaleElementReferenceException e){
          e.printStackTrace();
      }
      driver.navigate().back();
      driver.navigate().forward();
      driver.quit();





    }
}

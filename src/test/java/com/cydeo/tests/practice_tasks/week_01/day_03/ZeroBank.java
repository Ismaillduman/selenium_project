package com.cydeo.tests.practice_tasks.week_01.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ZeroBank {
    public static void main(String[] args) {
        /*Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”*/
        WebDriver driver= WebDriverFactory.getDriver("chrome","http://zero.webappsecurity.com/login.html");

       // WebElement header= driver.findElement(By.cssSelector("div[class='page-header']"));
        WebElement header= driver.findElement(By.xpath("//div[@class='page-header']"));
        System.out.println(header.getText());
        String actual= header.getText();
        String expected="Log in to ZeroBank";
        Assert.assertEquals(actual,expected);
        WebElement login_button=driver.findElement(By.xpath("//*[@type='submit']"));
        login_button.click();
        driver.quit();
    }
}

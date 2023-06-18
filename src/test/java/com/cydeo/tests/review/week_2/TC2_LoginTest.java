package com.cydeo.tests.review.week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class TC2_LoginTest {
    /*TC#2: Practice page Login test

    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username: "tomsmith"
    // 4. Enter password: "SuperSecretPassword"
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "You logged into a secure area!"
*/
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/login");
        WebElement username=driver.findElement(By.cssSelector("[name='username']"));
        WebElement password=driver.findElement(By.cssSelector("[name='password']"));
        WebElement login_button=driver.findElement(By.id("wooden_spoon"));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        login_button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement flash_text=driver.findElement(By.id("flash"));
        WebElement flash_text2=driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
        String expected_flash_text= "You logged into a secure area!";
        String actual_flash_text=flash_text2.getText();
        Assert.assertEquals(expected_flash_text,actual_flash_text,"Expected Text not equal with the actual Text");

        driver.close();


//driver.close(); close only current tab
//driver.quit(); close all of open tab

    }
}

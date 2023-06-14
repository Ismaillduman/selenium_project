package com.cydeo.tests.day_07_WebTables;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_4_LoginScenario {
    /*TC #4: Login scenario
1. Create new test and make set ups
2. Go to: http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal
USERNAME PASSWORD
helpdesk1@cydeo.com UserUser
helpdesk2@cydeo.com UserUser*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome","http://login1.nextbasecrm.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void login(){

        WebElement user_login=driver.findElement(By.name("USER_LOGIN"));
        WebElement user_password=driver.findElement(By.name("USER_PASSWORD"));
        WebElement login_button=driver.findElement(By.xpath("//input[@type='submit']"));
        user_login.sendKeys("hr1@cybertekschool.com");
        user_password.sendKeys("UserUser");
        login_button.click();
        BrowserUtils.verifyTitleContains("Portal",driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    /*TC #5: Create utility method
1. Create a new method for login
2. Create a method to make Task3 logic re-usable
3. When method is called, it should simply login
This method should have at least 2 overloaded versions.
Method #1 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
Method #2 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
• Arg2: String username
• Arg3: String password*/
    public static void login_crm(WebDriver driver){
        WebElement user_login=driver.findElement(By.name("USER_LOGIN"));
        WebElement user_password=driver.findElement(By.name("USER_PASSWORD"));
        WebElement login_button=driver.findElement(By.xpath("//input[@type='submit']"));
        user_login.sendKeys("hr1@cybertekschool.com");
        user_password.sendKeys("UserUser");
        login_button.click();
        BrowserUtils.verifyTitleContains("Portal",driver);



    }
    public static void login_crm(WebDriver driver,String username,String password){
        WebElement user_login=driver.findElement(By.name("USER_LOGIN"));
        WebElement user_password=driver.findElement(By.name("USER_PASSWORD"));
        WebElement login_button=driver.findElement(By.xpath("//input[@type='submit']"));
        user_login.sendKeys(username);
        user_password.sendKeys(password);
        login_button.click();
        BrowserUtils.verifyTitleContains("Portal",driver);



    }
}

package com.cydeo.tests.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TC_1CRM {
    /*TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
PS: Inspect and decide which locator you should be using to locate web
elements.*/
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("https://login1.nextbasecrm.com/");
        WebElement user_name = driver.findElement(By.className("login-inp"));
        user_name.sendKeys("incorrect_password");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("Wrong_Password");
        WebElement login_button = driver.findElement(By.className("login-btn"));
        login_button.click();
        WebElement errorMessage = driver.findElement(By.className("errortext"));
        String actual_error_message = errorMessage.getText();
        String expected_error_message = "Incorrect login or password";
        Assert.assertEquals(actual_error_message, expected_error_message);
        driver.quit();
    }
}

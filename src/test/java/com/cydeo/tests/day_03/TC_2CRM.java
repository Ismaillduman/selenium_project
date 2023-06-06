package com.cydeo.tests.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TC_2CRM {
    /*TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.*/
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://login1.nextbasecrm.com/");
        WebElement remember_text = driver.findElement(By.className("login-item-checkbox-label"));
        String actual_remember_text = remember_text.getText();
        String expected_remember_text = "Remember me on this computer";
        Assert.assertEquals(actual_remember_text, expected_remember_text);
        WebElement forgot_text = driver.findElement(By.className("login-link-forgot-pass"));
        String actual_forgot_text = forgot_text.getText();
        String expected_forgot_text = "FORGOT YOUR PASSWORD?";
        Assert.assertEquals(actual_forgot_text, expected_forgot_text);
        String actual_attribute_value = forgot_text.getAttribute("href");
        if (actual_attribute_value.contains("forgot_password=yes")) {
            System.out.println("Attribute contains text as expected");
        } else {
            System.err.println("Not Match as expected");
        }

        driver.quit();
    }
}

package com.cydeo.tests.day_04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_Css_Xpath_Practice {
/*XPATH and CSS Selector PRACTICES

DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible*/

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/forgot_password");
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[href='/']"));
        WebElement homeLink3 = driver.findElement(By.cssSelector("a.nav-link"));


        WebElement forgotPassword = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement email2 = driver.findElement(By.xpath(" //label"));

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement inputBox2 = driver.findElement(By.xpath("//input[contains(@pattern,'[a-z0-9')]"));

        WebElement retrievePassword = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrievePassword3 = driver.findElement(By.cssSelector("#form_submit"));

        WebElement cydeoText = driver.findElement(By.xpath("//div[contains(@style,'text')]"));
        WebElement cydeoText2 = driver.findElement(By.cssSelector("div[style]"));

        System.out.println("homeLink2.isDisplayed() = " + homeLink2.isDisplayed());
        System.out.println("forgotPassword = " + forgotPassword.isDisplayed());
        System.out.println("email.isDisplayed() = " + email.isDisplayed());
        System.out.println("inputBox2.isDisplayed() = " + inputBox2.isDisplayed());
        System.out.println("retrievePassword3.isDisplayed() = " + retrievePassword3.isDisplayed());
        System.out.println("cydeoText2.isDisplayed() = " + cydeoText2.isDisplayed());
        driver.quit();

    }
}

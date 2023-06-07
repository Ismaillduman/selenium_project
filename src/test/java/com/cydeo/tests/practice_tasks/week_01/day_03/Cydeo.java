package com.cydeo.tests.practice_tasks.week_01.day_03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cydeo {
    public static void main(String[] args) {
        /*HWP #4: Practice Cydeo – xpath locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “xpath” locator*/
        WebDriver driver= WebDriverFactory.getDriver("chrome","https://practice.cydeo.com/inputs");
        WebElement home= driver.findElement(By.xpath("//a[@class='nav-link']"));
        home.click();
        String actual=driver.getTitle();
        String  expected="Practice";
        Assert.assertEquals(actual,expected);

        //cssSelector tagName[attribute='value']
        //Relative xPath //tagName[@attribute='value']
        //Absolute xPath /html/......tagName[@attribute='value'] root path
    }
}

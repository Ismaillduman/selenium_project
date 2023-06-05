package com.cydeo.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://practice.cydeo.com/registration_form");
        WebElement header= driver.findElement(By.className("page-header"));
        String headerText= header.getText();
        System.out.println("headerText = " + headerText);
        String expectedText="Registration form";
        Assert.assertEquals(headerText,expectedText);

        WebElement firstNameBox= driver.findElement(By.name("firstname"));
        String expectedPlaceHolder= "first name";
        String actualPlaceHolder= firstNameBox.getAttribute("placeholder");//here we're getting placeholder attribute value
        System.out.println("actualPlaceHolder = " + actualPlaceHolder);
        Assert.assertEquals(actualPlaceHolder,expectedPlaceHolder);

        driver.quit();
    }
}

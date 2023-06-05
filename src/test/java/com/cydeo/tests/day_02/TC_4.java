package com.cydeo.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://library2.cybertekschool.com/login.html");
        WebElement emailBox = driver.findElement(By.className("form-control"));

        emailBox.sendKeys("incorrect@email.com");
        Thread.sleep(1000);
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));

        passwordBox.sendKeys("“incorrect password”");

        WebElement singIn = driver.findElement(By.tagName("button"));
        singIn.click();
        Thread.sleep(1000);
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div"));
        String actualAlert = alert.getText();
        System.out.println(actualAlert);
        System.out.println(alert.getAttribute("class"));
        String expectedAlert = "Sorry, Wrong Email or Password";
        Thread.sleep(1000);
        Assert.assertEquals(actualAlert, expectedAlert);
//getAttribute bana attribute value verir
        driver.quit();

    }
}

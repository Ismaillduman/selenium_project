package com.cydeo.tests.day_6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_4_iframe {
    /*TC #4: Iframe practice
1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void iframe() {

        WebElement iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement iframeText = driver.findElement(By.cssSelector("#tinymce"));
        Assert.assertTrue(iframeText.isDisplayed());


        driver.switchTo().parentFrame();
        WebElement parentText = driver.findElement(By.xpath("//div/h3"));
        String actual_parent_text = parentText.getText();
        String expected_text = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actual_parent_text, expected_text);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

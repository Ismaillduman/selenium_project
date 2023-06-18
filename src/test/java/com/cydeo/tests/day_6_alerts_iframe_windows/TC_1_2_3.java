package com.cydeo.tests.day_6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_1_2_3 {
    /*TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get( "http://practice.cydeo.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void alertsTest() {
        WebElement informationAlertButton = driver.findElement(By.cssSelector("[onclick='jsAlert()']"));
        WebElement confirmAlertButton = driver.findElement(By.cssSelector("[onclick='jsConfirm()']"));
        WebElement promptAlertButton = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));

        informationAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        System.out.println(actualText);
        String expected_result_text = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expected_result_text, "Not equal");

        confirmAlertButton.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        actualText = result.getText();
        String expected_result_text_2 = "You clicked: Ok";
        Assert.assertEquals(actualText, expected_result_text_2);
        Assert.assertTrue(result.isDisplayed());

        promptAlertButton.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        actualText = result.getText();
        String expected_prompt_alert = "You entered: hello";
        Assert.assertEquals(actualText,expected_prompt_alert);
    }

}

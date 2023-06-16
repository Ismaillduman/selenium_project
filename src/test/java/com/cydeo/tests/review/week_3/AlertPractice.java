package com.cydeo.tests.review.week_3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPractice {
    /*// TC : Alert practice
// 1. Open browser
// 2. Go to website: https://practice.cydeo.com/javascript_alerts
// 3. Click to “Click for JS Prompt” button
// 4. Send “hello” text to alert
// 5. Click to OK button from the alert
// 6. Verify “You entered: hello” text is displayed.*/
    @Test
public void test(){
        Driver.getDriver();
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");
        WebElement alert_button=Driver.getDriver().findElement(By.cssSelector("[onclick='jsAlert()']"));
        WebElement prompt_button=Driver.getDriver().findElement(By.cssSelector("[onclick='jsPrompt()']"));
        alert_button.click();
        Alert alert= Driver.getDriver().switchTo().alert();
        alert.accept();
        prompt_button.click();
        alert.accept();
        WebElement result= Driver.getDriver().findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You entered:");

        Driver.closeDriver();

    }
}

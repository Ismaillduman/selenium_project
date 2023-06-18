package com.cydeo.tests.review.week_3;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe {
    /*// TC : Iframe practice
    // 1. Users are already login and on the homepage of CRM app
    // 2. Users click the MESSAGE tab
    // 3. Users write test message
    // 4. Users click the SEND button
    // 5. Verify the message is displayed on the feed*/
    @Test
    public void test(){
        Faker faker= new Faker();
        Driver.getDriver().get("http://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(Driver.getDriver(), ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        WebElement messageTab=Driver.getDriver().findElement(By.id("feed-add-post-form-tab-message"));
        messageTab.click();
        WebElement iframe=Driver.getDriver().findElement(By.cssSelector("[class='bx-editor-iframe']"));
        Driver.getDriver().switchTo().frame(iframe);
        WebElement textBox=Driver.getDriver().findElement(By.xpath("(//body[contains(@style,'min-height:')])"));
        String message=faker.lorem().sentence();
        textBox.sendKeys(message);

        Driver.getDriver().switchTo().parentFrame();
        WebElement send_button=Driver.getDriver().findElement(By.id("blog-submit-button-save"));
        send_button.click();
        try {
            String actual_text=Driver.getDriver().findElement(By.xpath("//div[.='"+message+"']")).getText();
            System.out.println(actual_text);
            Assert.assertEquals(actual_text,message);
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[.='"+message+"']")).isDisplayed());
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
        Driver.closeDriver();








    }
}

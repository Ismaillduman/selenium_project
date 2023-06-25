package com.cydeo.tests.review.week_4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UpLoadTest {
    @Test
    public void upload_test() {
        Driver.getDriver().get("https://demo.guru99.com/test/upload/");
        BrowserUtils.sleep(1);
        WebElement iframe = Driver.getDriver().findElement(By.xpath("(//iframe)[4]"));
        Driver.getDriver().switchTo().frame(iframe);
        Driver.getDriver().findElement(By.xpath("(//*[.='Alle akzeptieren'])[1]")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().switchTo().parentFrame();


        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\issma\\Desktop\\geri yukle\\Interview Question");

        Driver.getDriver().findElement(By.id("terms")).click();
        Driver.getDriver().findElement(By.id("submitbutton")).click();
        BrowserUtils.sleep(2);
        String actual_confirm_message = Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']")).getText();

        String expectedMsg = "1 file\nhas been successfully uploaded.";
        Assert.assertEquals(actual_confirm_message, expectedMsg);

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

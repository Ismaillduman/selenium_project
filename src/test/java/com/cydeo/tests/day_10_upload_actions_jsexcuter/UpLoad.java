package com.cydeo.tests.day_10_upload_actions_jsexcuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpLoad {
    @Test
    public void test(){
        /*TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page*/
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        WebElement chooseFile=Driver.getDriver().findElement(By.id("file-upload"));
        WebElement fileUpload=Driver.getDriver().findElement(By.id("file-submit"));
        //chooseFile.click();
        chooseFile.sendKeys("C:\\Users\\issma\\Videos\\2023-06-21 13-31-25.mp4");
        fileUpload.click();
        WebElement confirmText= Driver.getDriver().findElement(By.xpath("(//*[.='File Uploaded!'])[2]"));
        Assert.assertTrue(confirmText.isDisplayed());

        Driver.closeDriver();
    }
}

package com.cydeo.tests.day_12_review;

import com.cydeo.Pages.DynamicControlsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {
    /*TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM*/
    DynamicControlsPage controlsPage;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        controlsPage =new DynamicControlsPage();
    }
    @Test

    public void explicit_wait_test(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        DynamicControlsPage controlsPage=new DynamicControlsPage();

        controlsPage.removeButton.click();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(controlsPage.loading));
        try {
            Assert.assertFalse(controlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println("That's mean checkbox is not on the page ");
        }

        Assert.assertEquals(controlsPage.itsGoneMessageText.getText(),"It's gone!");

        //Driver.closeDriver();
    }
    @Test
    public void enable_button_test(){

    }

}

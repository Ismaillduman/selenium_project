package com.cydeo.tests.office_hours.week_3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Iframe_WindowsHandles_Practice {
    //Step 1- Go to the above URL.
    //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
    //Step 3- Locate the “Visit W3Schools.com!” link and click it.
    //Step 4- Get all window handles and hold them in a list.
    //Step 5- Write to total window handle number to the console. It must be 2.
    //Step 6- Switch to the second window.
    //Step 7- Get the current window’s handle and write to the console window. It must be a second window handle.
    //Step 8- Check the upper left side logo in the second window.
    //Step 9- Go back (Switch) to the first window.
    //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
    //Step 11- Check the See Run Button Text. It must contain “Run >” text.
    @Test
    public void iframe_WindowHandles() {

        Driver.getDriver().get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        Driver.getDriver().findElement(By.id("accept-choices")).click();

        String main_window_handel = Driver.getDriver().getWindowHandle();
        System.out.println(main_window_handel);
        Driver.getDriver().switchTo().frame("iframeResult");
        Driver.getDriver().findElement(By.xpath("//*[.='Visit W3Schools.com!']")).click();

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        System.out.println(allWindowHandles.size());
        for (String eachWindowHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindowHandle);
            if (Driver.getDriver().getTitle().contains("W3Schools Online Web Tutorials")) {
                break;
            }

        }

        Assert.assertEquals(Driver.getDriver().getTitle(), "W3Schools Online Web Tutorials");

        WebElement logo= Driver.getDriver().findElement(By.xpath("//a[@title='Home']/i"));
        Assert.assertTrue(logo.isDisplayed());

        Driver.getDriver().switchTo().window(main_window_handel);

        System.out.println("main window handle"+ Driver.getDriver().getWindowHandle());

WebElement runButton= Driver.getDriver().findElement(By.id("runbtn"));
Assert.assertTrue(runButton.getText().contains("Run"));
//Driver.getDriver().close();

    }
}

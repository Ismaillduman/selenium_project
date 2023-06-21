package com.cydeo.tests.review.week_3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandel {
    /*// TC : Windows handle practice
    //    1. Open browser
    //    2. Go to website: https://demoqa.com/browser-windows
    //    3. Click on New Tab button
    //    4. Click on New Window button
    //    5. Click on New Window Message button
    //    6. Store parent window handle id in a variable
    //    7. Store all window handle ids in to a Set
    //    9. Print out each window title*/
    @Test
    public void multiple_windows_handling_test() throws InterruptedException {
        Driver.getDriver().get(" https://demoqa.com/browser-windows");
        String parentId=Driver.getDriver().getWindowHandle();
        System.out.println("parentId = " + parentId);
        WebElement newTab =Driver.getDriver().findElement(By.cssSelector("#tabButton"));
        WebElement newWindow=Driver.getDriver().findElement(By.cssSelector("#windowButton"));
        WebElement newMessage=Driver.getDriver().findElement(By.cssSelector("#messageWindowButton"));
        newTab.click();
        newWindow.click();
        newMessage.click();
        Set<String> windowsHandel= Driver.getDriver().getWindowHandles();
        System.out.println("windowsHandel.size() = " + windowsHandel.size());
        for (String eachWindow : windowsHandel) {



            System.out.println(eachWindow);
        }
        Driver.closeDriver();
    }
}

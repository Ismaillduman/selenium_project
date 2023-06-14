package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    ;
    public static void  sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> windowsHandel = driver.getWindowHandles();
        for (String eachWindow : windowsHandel) {
            driver.switchTo().window(eachWindow);
            if (driver.getCurrentUrl().contains(expectedTitle)) {
                break;
            }
        }

        String actualTitle = driver.getTitle();
        verifyTitleContains(expectedTitle,driver);
        System.out.println("actualTitle = " + actualTitle);
        String currentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
        Assert.assertTrue(currentUrl.contains(expectedInUrl));
    }

    /*TC #3: Create utility method
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title
Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle*/

    public static void verifyTitleContains(String expectedTitle,WebDriver driver){
        String currentTitle= driver.getTitle();
        Assert.assertTrue(currentTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
    }
    public static void verifyTitle(String expectedTitle,WebDriver driver){
        String currentTitle= driver.getTitle();
        Assert.assertEquals(currentTitle,expectedTitle);
    }
}

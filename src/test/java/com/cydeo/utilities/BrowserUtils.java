package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    ;
    public void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> windowsHandel = driver.getWindowHandles();
        for (String eachWindow : windowsHandel) {
            driver.switchTo().window(eachWindow);
            if (driver.getCurrentUrl().contains(expectedTitle)) {
                break;
            }
        }
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String currentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
        Assert.assertTrue(currentUrl.contains(expectedInUrl));
    }
}

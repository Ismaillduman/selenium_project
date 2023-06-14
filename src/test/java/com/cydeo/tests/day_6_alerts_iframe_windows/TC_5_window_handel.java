package com.cydeo.tests.day_6_alerts_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC_5_window_handel {
    WebDriver driver;
    /*TC #5: Window Handle practice
1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”*/
    @BeforeMethod
    public void setUp(){
        driver=WebDriverFactory.getDriver("chrome","https://practice.cydeo.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void windowHandel(){
        Assert.assertEquals(driver.getTitle(),"Windows");
        WebElement click=driver.findElement(By.cssSelector("[href='/windows/new']"));
        click.click();
        String mainWindowHandle= driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        Set<String> windowHandles=driver.getWindowHandles();
        for (String eachWindow : windowHandles) {
            System.out.println(eachWindow);
//            if(!eachWindow.equals(mainWindowHandle)){
//                driver.switchTo().window(eachWindow);
//                System.out.println(driver.getTitle());
//            }
            driver.switchTo().window(eachWindow);
               System.out.println(driver.getTitle());
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"New Window");
    }
}

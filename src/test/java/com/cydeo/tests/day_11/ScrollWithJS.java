package com.cydeo.tests.day_11;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollWithJS {
    /*TC #1: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method*/

    @Test
    public void test(){
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement homeLink= Driver.getDriver().findElement(By.cssSelector("[class='nav-link']"));
        WebElement cydeoLink= Driver.getDriver().findElement(By.xpath("//*[contains(@style,'text-align:')]"));


        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink,homeLink);
        BrowserUtils.sleep(2);

        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);
        BrowserUtils.sleep(2);

    }
}

package com.cydeo.tests.day_10_upload_actions_jsexcuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollWithJS {
    /*TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a. 750 pixels down 10 times.
b. 750 pixels up 10 times
JavaScript method to use : window.scrollBy(0,0)
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as*/
    @Test
    public void test() {
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,750)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-750)");
        }


        Driver.closeDriver();
    }
}

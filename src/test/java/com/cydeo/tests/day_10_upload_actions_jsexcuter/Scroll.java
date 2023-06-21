package com.cydeo.tests.day_10_upload_actions_jsexcuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scroll {
    @Test
    public void test() throws InterruptedException {
        /*TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method
TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button*/
        Driver.getDriver().get("https://practice.cydeo.com/");
        WebElement cydeoPowerText=Driver.getDriver().findElement(By.xpath("//*[contains(@style,'text-align: center;')]"));
        WebElement homeLink=Driver.getDriver().findElement(By.cssSelector("[class='nav-link']"));
        Actions actions= new Actions(Driver.getDriver());
        actions.scrollToElement(cydeoPowerText).perform();

        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        Thread.sleep(2000);

       // actions.scrollToElement(homeLink).perform();
        Driver.closeDriver();

    }
}

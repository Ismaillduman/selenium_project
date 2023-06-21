package com.cydeo.tests.day_10_upload_actions_jsexcuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {
    /*TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed*/
    @Test
    public void test(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement image1=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2=Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3=Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        WebElement user_1=Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement user_2=Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement user_3=Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

        Actions actions= new Actions(Driver.getDriver());

        actions.moveToElement(image1).perform();
        Assert.assertTrue(user_1.isDisplayed());

        actions.moveToElement(image2).perform();
        Assert.assertTrue(user_2.isDisplayed());

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user_3.isDisplayed());

        Driver.closeDriver();
    }
}

package com.cydeo.tests.day_11;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
    /*TC2 #: Drag and drop default value verification
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Verify big circle default text is as below.
3. Assert:
-Text in big circle changed to: “Drag the small circle here.”

TC3 #: Drag and drop into the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”*/
//    @Test
//    public void test(){
//        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
//        WebElement smallCircle= Driver.getDriver().findElement(By.id("draggable"));
//        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));
//
//        String actualBigCircleText=bigCircle.getText();
//        String expectedBigCircleText="Drag the small circle here.";
//
//        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);
//
//        Actions actions= new Actions(Driver.getDriver());
//
//       actions.dragAndDrop(smallCircle,bigCircle).build().perform();
//        //actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();
//        String expectedBigCircleTextAfterDrop="You did great!";
//        BrowserUtils.sleep(2);
//       String actualBigCircleTextAfterDrop=bigCircle.getText();
//        Assert.assertEquals(actualBigCircleTextAfterDrop,expectedBigCircleTextAfterDrop);
//
//    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
    /*TC4 #: Click and hold
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Click and hold the small circle.
3. Assert:
-Text in big circle changed to: “Drop here.”*/
    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        WebElement smallCircle= Driver.getDriver().findElement(By.id("draggable"));
        WebElement homeLink=Driver.getDriver().findElement(By.cssSelector("[class='nav-link']"));
        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));

        Actions actions= new Actions( Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(homeLink).perform();
        String bigCircleText= bigCircle.getText();
        String expectedBigCircleText="Drop here.";
        Assert.assertEquals(bigCircleText,expectedBigCircleText);
    }
    @Test
    public void  drag_and_drop_outside_of_the_big_circle(){
        /*TC5 #: Drag and drop outside of the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “Try again!”*/
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        WebElement smallCircle= Driver.getDriver().findElement(By.id("draggable"));
        WebElement homeLink=Driver.getDriver().findElement(By.cssSelector("[class='nav-link']"));
        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));

        Actions actions= new Actions( Driver.getDriver());

        actions.dragAndDrop(smallCircle,homeLink).perform();
        String bigCircleText= bigCircle.getText();
        String expectedBigCircleText="Try again!";
        Assert.assertEquals(bigCircleText,expectedBigCircleText);
    }
    /*TC6 #: Drag and hover
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag the small circle on top of the big circle, hold it, and verify.
3. Assert:
-Text in big circle changed to: “Now drop...”*/
    @Test
    public void  drag_and_hover(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        WebElement smallCircle= Driver.getDriver().findElement(By.id("draggable"));
        WebElement homeLink=Driver.getDriver().findElement(By.cssSelector("[class='nav-link']"));
        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));

        Actions actions= new Actions( Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();
        String bigCircleText= bigCircle.getText();
        String expectedBigCircleText="Now drop...";
        Assert.assertEquals(bigCircleText,expectedBigCircleText);
    }

}

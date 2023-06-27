package com.cydeo.tests.day_12_review;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class w3Schools {
    @Test
    public void cookies_handel(){
        Driver.getDriver().get("https://www.w3schools.com/");
        Driver.getDriver().findElement(By.id("accept-choices")).click();
    }
}

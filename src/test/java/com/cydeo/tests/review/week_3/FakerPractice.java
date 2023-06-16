package com.cydeo.tests.review.week_3;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FakerPractice {
    /*// TC: Java Faker practice
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username using java faker
    // 4. Enter password using java faker
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "Your username is invalid!"*/

    @Test
    public void test(){
        Faker faker= new Faker();
        Driver.getDriver();
        Driver.getDriver().get("https://practice.cydeo.com/login");

        WebElement username= Driver.getDriver().findElement(By.name("username"));
        username.sendKeys(faker.name().username());
        WebElement password= Driver.getDriver().findElement(By.name("password"));
        password.sendKeys(faker.bothify("##??###"));
        WebElement login_button=Driver.getDriver().findElement(By.id("wooden_spoon"));
        login_button.click();
        WebElement flash_text=Driver.getDriver().findElement(By.id("flash"));
        String actual_text=flash_text.getText();
        String expected_text="Your username is invalid!\n" +
                "×";

        Assert.assertEquals(actual_text,expected_text);

        Driver.closeDriver();

    }

}

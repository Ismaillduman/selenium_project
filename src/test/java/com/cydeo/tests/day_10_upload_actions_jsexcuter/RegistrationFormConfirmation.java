package com.cydeo.tests.day_10_upload_actions_jsexcuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationFormConfirmation {
    /*TC#1: Registration form confirmation
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form

3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.*/
    @Test
    public void test() {

        Faker faker = new Faker();

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form"));

        WebElement name = Driver.getDriver().findElement(By.name("firstname"));
        WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
        WebElement userName = Driver.getDriver().findElement(By.name("username"));
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        WebElement phone = Driver.getDriver().findElement(By.name("phone"));
        WebElement birthDay = Driver.getDriver().findElement(By.name("birthday"));
        WebElement gender = Driver.getDriver().findElement(By.xpath("//*[@value='male']"));
        WebElement department = Driver.getDriver().findElement(By.xpath("//*[@name='department']"));
        WebElement jobTitle = Driver.getDriver().findElement(By.xpath("//*[@name='job_title']"));
        WebElement language = Driver.getDriver().findElement(By.xpath("(//*[@class='form-check-input'])[1]"));
        WebElement signUp = Driver.getDriver().findElement(By.id("wooden_spoon"));

        name.sendKeys(faker.name().firstName());

        lastName.sendKeys(faker.name().lastName());

        userName.sendKeys(faker.name().username().replace(".", ""));

        email.sendKeys(faker.internet().emailAddress());

        password.sendKeys(faker.regexify("[A-Za-z0-9]{8}"));

        phone.sendKeys(faker.numerify("571-000-0000"));

        Date date = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String birth_day = sdf.format(date);
        birthDay.sendKeys(birth_day);

        gender.click();

        Select departments = new Select(department);
        departments.selectByIndex(2);
        departments.selectByVisibleText("Department of Engineering");

        Select jobTitles = new Select(jobTitle);
        jobTitles.selectByIndex(2);

        language.click();

        signUp.click();

        WebElement successText = Driver.getDriver().findElement(By.xpath("//*[text()=\"You've successfully completed registration!\"]"));
        Assert.assertTrue(successText.isDisplayed());

        String actual_text = successText.getText();
        String expected_text = "You've successfully completed registration!";
        Assert.assertEquals(actual_text, expected_text);

        Driver.closeDriver();

    }
}

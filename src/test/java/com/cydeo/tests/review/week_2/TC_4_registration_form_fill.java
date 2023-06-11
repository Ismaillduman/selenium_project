package com.cydeo.tests.review.week_2;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TC_4_registration_form_fill {
    /*// TC#4: Registration Form Page Filling Form Test

    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Enter First name: "John"
    // 4. Enter Last name: "Smith"
    // 5. Enter Username: "johnsmith123"
    // 6. Enter Email address: "john.smith@email.com"
    // 7. Enter password: "John1234"
    // 8. Enter Phone number: "123-456-7890"
    // 9. Click to "Male" from Gender
    // 10. Enter Date of birth "01/28/1990"
    // 11. Select "Department of Engineering" from Department/Office dropdown
    // 12. Select "SDET" from Job title dropdown
    // 13. Click to "Java" from languages
    // 14. Click to "Sign up" button
    // 15. Verify text displayed on page
    //     Expected: "Well done!"*/
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/registration_form");

        WebElement first_name = driver.findElement(By.name("firstname"));
        first_name.sendKeys("John");

        WebElement last_name = driver.findElement(By.name("lastname"));
        last_name.sendKeys("Smith");

        WebElement user_name = driver.findElement(By.xpath("//input[@name='username']"));
        user_name.sendKeys("johnsmith123");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john.smith@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("John1234");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("123-456-7890");

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.sendKeys("01/28/1990");

        WebElement gender = driver.findElement(By.cssSelector("[value='male']"));
        gender.click();
        Assert.assertTrue("gender not selected", gender.isSelected());

        WebElement department = driver.findElement(By.xpath("//select[@name='department']"));
        department.click();
        List<WebElement> listOfLinks= driver.findElements(By.cssSelector("option[value]"));
        for (WebElement each_department : listOfLinks) {
            System.out.println("Departments name: "+each_department.getText());

        }
        System.out.println("\n");

        WebElement department_of_engineering = driver.findElement(By.cssSelector("[value='DE']"));
        department_of_engineering.click();
        Assert.assertTrue("Department is not visible", department_of_engineering.isDisplayed());

        WebElement jobTitle = driver.findElement(By.name("job_title"));
        jobTitle.click();
        List<WebElement> listOfJob=driver.findElements(By.xpath("(//div[@*='col-sm-5']//select)[2]/option"));
        for (WebElement eachJob : listOfJob) {
            System.out.println("job_title name : "+eachJob.getText());
        }

        WebElement SDET = driver.findElement(By.xpath("//*[.='SDET']"));
        SDET.click();

        WebElement languages = driver.findElement(By.id("inlineCheckbox2"));
        languages.click();

        WebElement sign_up = driver.findElement(By.id("wooden_spoon"));
        sign_up.click();

        WebElement done_text = driver.findElement(By.cssSelector("[class='alert-heading']"));
        String actual_text = done_text.getText();
        String expected_text = "Well done!";
        Assert.assertEquals(actual_text, expected_text);

        driver.quit();
    }
}

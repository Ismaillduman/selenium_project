package com.cydeo.tests.day_11;

import com.cydeo.Pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLibrary {
    /*



NOTE: FOLLOW POM DESIGN PATTERN



NOTE: FOLLOW POM DESIGN PATTERN*/
    LibraryLoginPage login;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://library1.cydeo.com");
        login = new LibraryLoginPage();
    }

    @Test
    public void required_field_error_message_test() {
       /*TC #7: Required field error message test



3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
NOTE: FOLLOW POM DESIGN PATTERN*/
        login.signIn.click();
        String expected_alert_text = "This field is required.";
        String actual_text = login.alert.getText();
        Assert.assertEquals(actual_text, expected_alert_text);


    }

    @Test
    public void invalid_email_format_error_message_test() {
    /*TC #8: Invalid email format error message test

3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.*/
        login.email.sendKeys("username" + Keys.ENTER);
        String actual_email_error_message = login.emailError.getText();
        String expected_error_message = "Please enter a valid email address.";
        Assert.assertEquals(actual_email_error_message, expected_error_message);


    }

    @Test
    public void library_negative_login() {
    /*       TC #9: Library negative login
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter incorrect username or incorrect password
4- Verify title expected error is displayed:
Expected: Sorry, Wrong Email or Password*/
        login.email.sendKeys("iss@gmail.com");
        login.password.sendKeys("sfdgdgd");
        login.signIn.click();
        BrowserUtils.sleep(2);
        String actual_error_text = login.alert.getText();
        String expected_text = "Sorry, Wrong Email or Password";
        Assert.assertEquals(actual_error_text, expected_text);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

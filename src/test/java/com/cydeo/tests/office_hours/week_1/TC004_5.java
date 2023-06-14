package com.cydeo.tests.office_hours.week_1;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TC004_5 {
    /* ** TC004 As a user I should be able to see the password hidden as default

 1- Setup the "browser driver"
 2- Go to "https://vytrack.com"
 3- Click Login label
 4- Login to application with username as "User1" and password as "UserUser123"
 5- Verify the password is hidden*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://vytrack.com/");
        BrowserUtils.sleep(3);
    }

    // @Test(priority = 2)
    public void verifyLogin() {
        WebElement loginText = driver.findElement(By.xpath("(//a[@href='http://app.vytrack.com'])[1]"));

        loginText.click();
        String actual_title = driver.getTitle();
        Assert.assertTrue(actual_title.contains("Login"));
        WebElement username_box = driver.findElement(By.cssSelector("#prependedInput"));
        WebElement password_box = driver.findElement(By.cssSelector("#prependedInput2"));
        WebElement login_button = driver.findElement(By.cssSelector("#_submit"));
        username_box.sendKeys("User1");
        password_box.sendKeys("UserUser123");
        Assert.assertTrue(password_box.getText().isEmpty());


    }

    /* TC005 As a user I should be able to see Home, About us, Our Approach, Product and Services,
     Contact and LOGIN labels are displayed

  1-open a chrome browser
  2-goto https://vytrack.com/
  3-verify Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed*/
    @Test(priority = 1)
    public void verifyLabels() {
        List<WebElement> topMenu = driver.findElements(By.xpath("//*[@id='top-menu']/li"));
        for (WebElement eachElement : topMenu) {
            System.out.println(eachElement.getText());
            Assert.assertTrue(eachElement.isDisplayed());

        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

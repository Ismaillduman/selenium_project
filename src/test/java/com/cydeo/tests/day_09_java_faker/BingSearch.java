package com.cydeo.tests.day_09_java_faker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BingSearch {
    /*TC #1: Bing search
1- Open a chrome browser
2- Go to: https://bing.com
3- Write “apple” in search box
4- Verify title:

Expected: apple - Search

Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.*/
//    WebDriver driver;
//    @BeforeMethod
//    public void setUp(){
//        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"),ConfigurationReader.getProperty("env3"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
    @Test
    public void test1(){


        WebElement rejection= Driver.getDriver().findElement(By.cssSelector("[class='bnp_btn_reject']"));
        WebElement search_box= Driver.getDriver().findElement(By.cssSelector("#sb_form_q"));
        rejection.click();
        search_box.sendKeys(ConfigurationReader.getProperty("search.keyword"),Keys.ENTER);
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("search.keyword")+" - Suchen",Driver.getDriver());
    }

    @Test
    public void test2(){


        WebElement rejection= Driver.getDriver().findElement(By.cssSelector("[class='bnp_btn_reject']"));
        WebElement search_box= Driver.getDriver().findElement(By.cssSelector("#sb_form_q"));
        rejection.click();
        search_box.sendKeys(ConfigurationReader.getProperty("search.keyword"),Keys.ENTER);
        BrowserUtils.verifyTitle(ConfigurationReader.getProperty("search.keyword")+" - Suchen",Driver.getDriver());
    }
    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
        //Driver.getDriver().quit();
    }


}

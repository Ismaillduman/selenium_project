package com.cydeo.tests.day_08webTablesCont_properties_configReader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC4_Google_Search {
    /*TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"), ConfigurationReader.getProperty("env2"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1() {


        WebElement rejection = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[1]"));
        rejection.click();
        WebElement searchBox = driver.findElement(By.cssSelector("#APjFqb"));
        searchBox.sendKeys(ConfigurationReader.getProperty("search.keyword"));
        searchBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(2);
        String expectedTitle=ConfigurationReader.getProperty("search.keyword")+" - Google Suche";

        BrowserUtils.verifyTitle(expectedTitle, driver);

    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }
}

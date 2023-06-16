package com.cydeo.tests.day_08webTablesCont_properties_configReader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTable {

    /*TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021*/
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/web-tables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @Test
//    public void webTable() {
//        WebElement name = driver.findElement(By.xpath("(//*[@class='SampleTable']//tbody//td[2])[.='Bob Martin']"));
//        String actualName = name.getText();
//        String expectedName = "Bob Martin";
//        Assert.assertEquals(expectedName, actualName);
//        WebElement dueDate = driver.findElement(By.xpath("(//*[@class='SampleTable']//tbody//td[2])[.='Bob Martin']/following-sibling::td[3]"));
//        String actualDueDate= dueDate.getText();
//        String expectedDate="12/31/2021";
//        Assert.assertEquals(actualDueDate,expectedDate);
//    }

    @Test
    public  void orderDate(){

        System.out.println("Alexandra Gray--> "+WebTableUtils.returnOrderDate("Alexandra Gray", driver));

        WebTableUtils.orderVerify("Stewart Dawidson","03/29/2021",driver);

    }
    @AfterMethod
    public void tearDown(){
       //driver.quit();
    }
}

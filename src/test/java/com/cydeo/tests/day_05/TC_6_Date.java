package com.cydeo.tests.day_05;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_6_Date {
    /*TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1933” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number*/

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void dateSelect() {
        WebElement year= driver.findElement(By.xpath("//*[@id='year']"));
        WebElement day= driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month= driver.findElement(By.xpath("//*[@id='month']"));
        Select selectYear= new Select(year);
        Select selectDay= new Select(day);
        Select selectMonth= new Select(month);
        year.click();
        selectYear.selectByValue("1933");
        day.click();
        selectDay.selectByIndex(1);
        month.click();
        selectMonth.selectByValue("11");



    }
}

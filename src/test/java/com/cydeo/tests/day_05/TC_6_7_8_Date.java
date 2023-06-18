package com.cydeo.tests.day_05;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_6_7_8_Date {
    /*TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1933” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number

TC #7: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)

TC #8: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”*/

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get( "https://practice.cydeo.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dateSelect() {
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));


        Select selectYear = new Select(year);
        Select selectDay = new Select(day);
        Select selectMonth = new Select(month);

        year.click();
        selectYear.selectByValue("1933");
        day.click();
        selectDay.selectByIndex(1);
        month.click();
        selectMonth.selectByValue("11");
        String actual_year = selectYear.getFirstSelectedOption().getText();
        String actual_month = selectMonth.getFirstSelectedOption().getText();
        String actual_day = selectDay.getFirstSelectedOption().getText();
        String expected_year = "1933";
        String expected_month = "December";
        String expected_day = "1";

        Assert.assertEquals(actual_year, expected_year);
        Assert.assertEquals(actual_month, expected_month);
        Assert.assertEquals(actual_day, expected_day);


        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select selectState = new Select(state);

        state.click();
        selectState.selectByValue("IL");
        selectState.selectByVisibleText("Virginia");
        selectState.selectByIndex(5);
        String actual_state = selectState.getFirstSelectedOption().getText();
        String expected_state = "California";

        Assert.assertEquals(actual_state, expected_state);

        WebElement non_selectedDropDown= driver.findElement(By.id("dropdownMenuLink"));
        non_selectedDropDown.click();
        WebElement faceBook= driver.findElement(By.xpath("(//*[@class='dropdown-item'])[4]"));
        faceBook.click();

       String actual_title= driver.getTitle();
       String expected_title="Facebook – Anmelden oder Registrieren";
       Assert.assertEquals(actual_title,expected_title,"Not equal title");


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

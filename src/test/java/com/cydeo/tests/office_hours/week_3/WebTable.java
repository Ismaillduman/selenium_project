package com.cydeo.tests.office_hours.week_3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    /*Task 2:  Web Table

   Step 1- Click on calendar

   Step 2- Get all td of tables using findElements method

   Step 3- using for loop get the text of all elements

   Step 4- using if else condition we will check the specific date

   Step 5- If the date is matched then click and break the loop.*/
    @Test
    public void webTable_test() {

        Driver.getDriver().get(" https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        Driver.getDriver().findElement(By.id("datepicker")).click();

        List<WebElement> allDays = Driver.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

//        for (WebElement eachDay : allDays) {
//            String day=eachDay.getText();
//            System.out.println(eachDay);
//            if(day.equalsIgnoreCase("5")){
//                eachDay.click();
//                break;
//            }
//        }

        for (WebElement eachDay : allDays) {
            String day = eachDay.getText();

            if (day.isBlank()||day.equalsIgnoreCase("5")) {
                continue;
            }
            System.out.println(day);
             eachDay.click();


        }


    }
}

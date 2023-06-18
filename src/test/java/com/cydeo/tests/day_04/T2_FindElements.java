package com.cydeo.tests.day_04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T2_FindElements {
    /*TC #2: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links*/
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/abtest");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> listOfLinks= driver.findElements(By.tagName("a"));
        System.out.println(listOfLinks.size());
        for (WebElement eachLinks : listOfLinks) {
            System.out.println(eachLinks.getText());
        }
        for (WebElement element : listOfLinks) {
            System.out.println("Attribute Values: "+element.getAttribute("href"));
        }

driver.quit();
    }
}

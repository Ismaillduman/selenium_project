package com.cydeo.tests.day_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RadioButtonUtility {


    public void clickAndVerifyRadioButton(WebDriver driver, String attribute, String attributeId) {
        //List<WebElement> elements = driver.findElements(By.xpath("//input[@name='" + attribute + "']"));
        List<WebElement> elements = driver.findElements(By.name(attribute));

        for (WebElement eachElement : elements) {
            String attributes = eachElement.getAttribute("name");
            String id = eachElement.getAttribute("id");
            System.out.println(id);
            if (attributeId.equals(id) && attributes.equals(attribute)) {
                eachElement.click();
                Assert.assertTrue(eachElement.isSelected());
            }
        }


    }

}


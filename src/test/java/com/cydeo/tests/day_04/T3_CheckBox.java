package com.cydeo.tests.day_04;

import com.cydeo.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_CheckBox {
    /*TC#3: Checkboxes
1. Go to https://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
*/
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome", "https://practice.cydeo.com/checkboxes");

        WebElement checkBox = driver.findElement(By.cssSelector("#box1"));

        boolean isChecked = checkBox.isSelected();
        Assert.assertTrue("Checkbox is selected", !isChecked);

        WebElement checkBox2 = driver.findElement(By.cssSelector("#box2"));
        Assert.assertTrue("Check box is not selected", checkBox2.isSelected());


        checkBox.click();
        checkBox2.click();
        Assert.assertTrue("check box is not selected",checkBox.isSelected());
        Assert.assertTrue("check box is selected",!checkBox2.isSelected());




    }
}

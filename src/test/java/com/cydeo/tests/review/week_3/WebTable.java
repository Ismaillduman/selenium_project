package com.cydeo.tests.review.week_3;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class WebTable {
    @Test
    public void test() {
        /*/ TC : Web table practice
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/tables
    // 3. Print table data as a single String, not so common, but useful sometimes
    // 4. verify tconway@eartconhlink.net is anywhere in the table
    // 5. print all column names in single line
    // 6. print each column name in separate lines using a loop and findElements method
*/
        String data = "";
        Driver.getDriver().get("https://practice.cydeo.com/tables");
        List<List<WebElement>> elements = Collections.singletonList(Driver.getDriver().findElements(By.xpath("//tbody//tr")));
        for (List<WebElement> eachElement : elements) {
            for (WebElement eachWebElement : eachElement) {
                if (eachWebElement == Driver.getDriver().findElement(By.xpath("(//*[@id='table1']//tr//td)[.='Conway']/following-sibling::td[4]"))) {
                    Assert.assertTrue(eachElement.contains(Driver.getDriver().findElement(By.xpath("(//*[@id='table1']//tr//td)[.='Conway']/following-sibling::td[4]"))));
                }
                data += "\n" + eachWebElement.getText();

            }
        }
        System.out.println(data);

        WebElement conway_link = Driver.getDriver().findElement(By.xpath("(//*[@id='table1']//tr//td)[.='Conway']/following-sibling::td[4]"));

        Assert.assertTrue(conway_link.isDisplayed());
        String columnNames = "";
        List<WebElement> headers = Driver.getDriver().findElements(By.xpath("(//*[@id='table1']//tr)[1]"));
        for (WebElement eachHeader : headers) {

            columnNames+=eachHeader.getText();
            System.out.println("columnNames = " + columnNames);
        }
        List<WebElement> header = Driver.getDriver().findElements(By.xpath("//*[@id='table1']//tr/th"));
        for (WebElement eachHeader : header) {
            System.out.println("Each column Name--> " + eachHeader.getText());
        }
    }
}

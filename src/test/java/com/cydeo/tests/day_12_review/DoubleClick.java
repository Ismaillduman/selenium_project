package com.cydeo.tests.day_12_review;

import com.cydeo.Pages.W3SchoolsTryItEditorPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
    @Test
    public void double_click_test(){
        /*1. Go to
https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
ck2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
NOTE: FOLLOW POM*/
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli\n" +
                "ck2");
        W3SchoolsTryItEditorPage editorPage= new W3SchoolsTryItEditorPage();

        editorPage.cookies.click();
//        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(editorPage.iframe));
        WebElement iframe= editorPage.iframe;
        Driver.getDriver().switchTo().frame(iframe);
        Actions action= new Actions(Driver.getDriver());
        action.doubleClick(editorPage.doubleClickText).perform();
    }
}

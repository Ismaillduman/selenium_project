package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3SchoolsTryItEditorPage {
    public W3SchoolsTryItEditorPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "iframeResult")
    public WebElement iframe;

    @FindBy(css = "#demo")
    public WebElement doubleClickText;
    @FindBy(css = "#accept-choices")
    public WebElement cookies;


}

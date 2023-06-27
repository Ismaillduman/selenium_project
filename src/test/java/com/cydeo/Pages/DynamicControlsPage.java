package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Remove']")
    public WebElement removeButton;
    @FindBy(id = "message")
    public WebElement itsGoneMessageText;

    @FindBy(id = "checkbox")
    public WebElement checkBox;
    @FindBy(id = "loading")
    public WebElement loading;

    @FindBy(css = "[onclick='swapInput()']")
    public WebElement enableButton;

    @FindBy(css = "[id='message']")
    public WebElement enableMessage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;
}

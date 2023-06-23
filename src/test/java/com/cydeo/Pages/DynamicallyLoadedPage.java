package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage {
    public DynamicallyLoadedPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "alert")
    public WebElement alertText;

    @FindBy(css = ".rounded.mx-auto.d-block")
    public WebElement image;

}

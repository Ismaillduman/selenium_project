package com.cydeo.Pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage {
    public DynamicallyLoadedPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}

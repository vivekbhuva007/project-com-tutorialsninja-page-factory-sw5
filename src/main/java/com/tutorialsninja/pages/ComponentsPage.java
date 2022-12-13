package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;


    public String getComponentsText() {
        CustomListeners.test.log(Status.PASS, "get Components Text");
        return getTextFromElement(componentsText);
    }
}

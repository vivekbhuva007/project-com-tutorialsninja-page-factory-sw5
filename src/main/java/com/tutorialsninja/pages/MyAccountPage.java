package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public String getAccountLogoutText() {
        CustomListeners.test.log(Status.PASS, "get Account LogoutText");
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        CustomListeners.test.log(Status.PASS, "get Your Account Has Been Created Text");
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS, "click On Continue Button");
        clickOnElement(continueBtn);
    }
}

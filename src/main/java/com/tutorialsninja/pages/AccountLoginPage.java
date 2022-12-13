package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
    WebElement loginBtn;


    public String getReturningCustomerText() {

        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS, "New Customer Text");
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        CustomListeners.test.log(Status.PASS,"Enter Email " + email);
        sendTextToElement(emailAddressField, email);
    }


    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS,"Enter password " + password);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        CustomListeners.test.log(Status.PASS, "Click on Log In Button ");
        clickOnElement(By.xpath("//input[@value='Login']"));
    }

}

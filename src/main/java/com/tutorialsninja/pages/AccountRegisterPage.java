package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement LastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    WebElement subscribeRadios;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;




    public String getRegisterAccountText() {
        CustomListeners.test.log(Status.PASS, "get Register Account Text");
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        CustomListeners.test.log(Status.PASS,"Enter First Name " + fName);
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        CustomListeners.test.log(Status.PASS,"Enter Last Name " + lName);
        sendTextToElement(LastNameField, lName);
    }

    public void enterEmail(String email) {
        CustomListeners.test.log(Status.PASS,"Enter Email " + email);
        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {
        CustomListeners.test.log(Status.PASS,"Enter Telephone" + telephone);
        sendTextToElement(telephoneField, telephone);
    }

    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS,"Enter Password" + password);
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String cPassword) {
        CustomListeners.test.log(Status.PASS,"Enter Confirm Password" + cPassword);
        sendTextToElement(passwordConfirmField, cPassword);
    }

    public void selectSubscription(String option) {
        List<WebElement> radioButtons = getListOfElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        CustomListeners.test.log(Status.PASS, "Click on Privacy Policy Check Box ");
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS, "Click on Continue Button");
        clickOnElement(continueBtn);
    }

}

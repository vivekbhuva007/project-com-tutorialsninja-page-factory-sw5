package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup

    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() {
        CustomListeners.test.log(Status.PASS,"Shopping Cart");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        CustomListeners.test.log(Status.PASS,"Product Name");
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        CustomListeners.test.log(Status.PASS,"Pick Delivery Date");
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        CustomListeners.test.log(Status.PASS,"Select Model");
        return getTextFromElement(model);
    }

    public String getTotal() {
        CustomListeners.test.log(Status.PASS,"Total");
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        CustomListeners.test.log(Status.PASS,"Change the quantity");
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        CustomListeners.test.log(Status.PASS,"Update the quantity");
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        CustomListeners.test.log(Status.PASS,"Get success Message");
        return getTextFromElement(successModifiedMessage);
    }
}

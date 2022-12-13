package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;



    public String getDesktopsText() {
        CustomListeners.test.log(Status.PASS, "get Desktops Text");
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }
    public void selectProductByName(String product) {
        CustomListeners.test.log(Status.PASS, "select Product By Name");
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        CustomListeners.test.log(Status.PASS, "select Sort By Option"+ option);
        selectByVisibleTextFromDropDown(sortBy, option);
    }
}

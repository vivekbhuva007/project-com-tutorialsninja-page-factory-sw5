package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage ;
    ProductPage productPage ;

    ShoppingCartPage cartPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage= new HomePage();
       desktopPage= new DesktopPage();
       productPage= new ProductPage();
       cartPage= new ShoppingCartPage();
    }

    @Test (groups = {"regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show All Desktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        desktopPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    @Test (groups = {"regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.selectCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show All Desktops");
        desktopPage.selectSortByOption("Name (A - Z)");
        desktopPage.selectProductByName("HP LP3065");
        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");
        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");
        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}

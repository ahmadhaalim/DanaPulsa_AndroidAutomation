package demo.pages;

import demo.locator.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage {

    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean onHomePage(){
        pageObject.waitUntilDisplayed(HomePageLocator.Home_Button);
        return pageObject.checkIfDisplayed(HomePageLocator.Home_Button);
    }

    public void chooseMobileRecharge() {
        pageObject.clickOn(HomePageLocator.MobileRecharge_Button);
    }

    public void clickHistoryButton() {
        pageObject.clickOn(HomePageLocator.History_Button);
    }

    public void clickPromotionItem() {
        pageObject.clickOn(HomePageLocator.Promotion_Banner);
    }

    public void clickViewAll(){
        pageObject.clickOn(HomePageLocator.ViewAll_Button);
    }
}

package demo.pages;

import demo.locator.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(HomePageLocator.DANA_Balance);
    }
    public void clickMobileRechargeButton() {
        clickOn(HomePageLocator.MobileRecharge_Button);
    }
    public void clickPromotionBanner() {
        clickOn(HomePageLocator.Promotion_Banner);
    }
    public void clickViewAllButton() {
        clickOn(HomePageLocator.ViewAll_Button);
    }
    public void clickHomeButton() {
        clickOn(HomePageLocator.Home_Button);
    }
    public void clickHistoryButton() {
        clickOn(HomePageLocator.History_Button);
    }
    public void clickProfileButton() {
        clickOn(HomePageLocator.Profile_Button);
    }
}

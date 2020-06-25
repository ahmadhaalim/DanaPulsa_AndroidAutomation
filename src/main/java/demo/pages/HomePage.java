package demo.pages;

import demo.locator.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(HomePageLocator.DANA_Balance);
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
}

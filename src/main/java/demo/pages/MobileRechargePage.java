package demo.pages;

import demo.locator.MobileRechargePageLocator;
import pageobjects.AndroidPageObject;

public class MobileRechargePage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(MobileRechargePageLocator.PhoneNumber_Field);
    }
    public void clickBackButton() {
        clickOn(MobileRechargePageLocator.Back_Button);
    }
}

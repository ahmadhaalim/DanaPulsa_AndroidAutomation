package demo.pages;

import demo.locator.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage extends AndroidPageObject implements HomePageLocator {

    public boolean isOnPage() {
        waitUntilDisplayed(BUTTON_MOBILE_RECHARGE);
        return checkIfDisplayed(BUTTON_MOBILE_RECHARGE);
    }

    public void tapProfileIcon() {
        clickOn(BUTTON_PROFILE);
    }
}

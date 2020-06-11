package demo.pages.MainPageHalim;

import demo.locator.MainPageLocator;
import pageobjects.AndroidPageObject;

public class MainPage extends AndroidPageObject {
    public void isInTheMainPage(){
        waitUntilDisplayed(MainPageLocator.MOBILE_CHARGE_BUTTON);
    }

    public void clickProfileMenu(){
        clickOn(MainPageLocator.PROFILE_MENU);
    }

}

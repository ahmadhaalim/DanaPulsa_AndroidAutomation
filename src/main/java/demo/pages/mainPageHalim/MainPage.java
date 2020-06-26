package demo.pages.mainPageHalim;

import demo.locator.MainPageLocator;
import pageobjects.AndroidPageObject;

public class MainPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(MainPageLocator.MOBILE_CHARGE_BUTTON);
    }

    public void clickProfileMenu() throws InterruptedException {
        Thread.sleep(8000);
        clickOn(MainPageLocator.PROFILE_MENU);
    }

}

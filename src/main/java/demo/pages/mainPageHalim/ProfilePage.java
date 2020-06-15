package demo.pages.mainPageHalim;

import demo.locator.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage extends AndroidPageObject {
    public void clickSignOutMenu(){
        clickOn(ProfilePageLocator.SIGN_OUT_MENU);
    }
    public boolean isOnPage(){
        return checkIfDisplayed(ProfilePageLocator.SIGN_OUT_MENU);
    }
    public void clickChangePinMenu(){
        clickOn(ProfilePageLocator.CHANGE_PIN_MENU);
    }
}

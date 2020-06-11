package demo.pages.MainPageHalim;

import demo.locator.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage extends AndroidPageObject {
    public void clickSignOutMenu(){
        clickOn(ProfilePageLocator.SIGN_OUT_MENU);
    }
}

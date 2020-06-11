package demo.pages;

import demo.locator.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(ProfilePageLocator.Phone_Text);
    }
    public String getName() {
        return getText(ProfilePageLocator.Name_Text);
    }
    public String getEmail() {
        return getText(ProfilePageLocator.Email_Text);
    }
    public String getPhoneNumber() {
        return getText(ProfilePageLocator.Phone_Text);
    }
    public void clickProfileButton() {
        clickOn(ProfilePageLocator.Profile_Button);
    }
    public void clickChangePinButton() {
        clickOn(ProfilePageLocator.ChangePin_Button);
    }
    public void clickSignOutButton() {
        clickOn(ProfilePageLocator.SignOut_Button);
    }
}

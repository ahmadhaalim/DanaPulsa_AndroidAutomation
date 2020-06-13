package demo.pages;

import demo.locator.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(ProfilePageLocator.Phone_Text);
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
    public void clickChangePinButton() {
        clickOn(ProfilePageLocator.ChangePin_Button);
    }
    public void clickSignOutButton() {
        clickOn(ProfilePageLocator.SignOut_Button);
    }
    public String getWarningMessage() {
        return getText(ProfilePageLocator.Warning_Message);
    }
}

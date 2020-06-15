package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;
import demo.locator.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage extends AndroidPageObject implements ProfilePageLocator {

    public String getFullNameText() {
        return androidDriver.findElement(TEXT_USER_NAME).getText();
    }

    public String getEmailText() {
        return androidDriver.findElement(TEXT_USER_EMAIL).getText();
    }

    public String getPhoneNumberText() {
        return androidDriver.findElement(TEXT_USER_PHONE).getText();
    }

    public void tapSignOutButton() {
        clickOn(BUTTON_SIGN_OUT);
    }
}

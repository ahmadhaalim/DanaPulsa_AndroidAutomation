package demo.pages;

import demo.locator.SignInPageLocator;
import pageobjects.AndroidPageObject;

public class SignInPage extends AndroidPageObject implements SignInPageLocator {

    public boolean isOnPage() {
        return waitUntilDisplayed(BUTTON_SIGN_IN);
    }

    public void tapSignUpButton() {
        clickOn(BUTTON_SIGN_UP);
    }
}

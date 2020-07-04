package demo.pages;

import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpConfirmPinPage extends AndroidPageObject {
    public void inputConfirmPIN(String input) {
        typeON(SignUpPageLocator.EDIT_CONFIRM_PIN, input);
    }
}

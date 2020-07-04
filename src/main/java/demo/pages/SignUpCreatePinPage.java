package demo.pages;

import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpCreatePinPage extends AndroidPageObject {

    public void inputPIN(String input) {
        typeON(SignUpPageLocator.EDIT_CREATE_PIN, input);
    }
}

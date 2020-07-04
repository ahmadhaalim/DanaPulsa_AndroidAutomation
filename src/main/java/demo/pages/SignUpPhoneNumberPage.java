package demo.pages;

import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpPhoneNumberPage extends AndroidPageObject {

    public void inputPhoneNumber(String input) {
        typeON(SignUpPageLocator.EDIT_PHONE_NUMBER,input);
    }
}

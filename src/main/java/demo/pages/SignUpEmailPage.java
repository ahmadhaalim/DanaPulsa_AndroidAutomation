package demo.pages;

import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpEmailPage extends AndroidPageObject {

    public void inputEmail(String input) {
        typeON(SignUpPageLocator.EDIT_EMAIL, input);
    }
}

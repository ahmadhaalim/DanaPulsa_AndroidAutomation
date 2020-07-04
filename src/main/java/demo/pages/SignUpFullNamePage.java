package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpFullNamePage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(SignUpPageLocator.EDIT_FULL_NAME);
    }

    public void inputFullName(String input) {
        typeON(SignUpPageLocator.EDIT_FULL_NAME, input);
    }
}

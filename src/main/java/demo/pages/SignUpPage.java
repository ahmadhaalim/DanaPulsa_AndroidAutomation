package demo.pages;

import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpPage extends AndroidPageObject {

    public void isOnPage(){
        waitUntilDisplayed(SignUpPageLocator.InputName_Field);
    }
    public void clickBackButton() {
        clickOn(SignUpPageLocator.Back_Button);
    }
}

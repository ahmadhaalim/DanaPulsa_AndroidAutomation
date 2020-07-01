package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.SignInInputPinPageLocator;
import pageobjects.AndroidPageObject;

public class SignInInputPinPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(SignInInputPinPageLocator.EnterYourPin_Text);
    }
    public void inputPin(String pin) {
        typeON(SignInInputPinPageLocator.Input_Pin_Field, pin);
    }
    public void clickForgotPinButton() {
        clickOn(SignInInputPinPageLocator.ForgotPin_Button);
    }
}


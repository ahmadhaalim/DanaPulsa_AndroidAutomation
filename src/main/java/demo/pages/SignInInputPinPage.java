package demo.pages;

import demo.locator.SignInInputPinPageLocator;
import pageobjects.AndroidPageObject;

public class SignInInputPinPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(SignInInputPinPageLocator.EnterYourPin_Text);
    }
    public void inputPin(String pin) {
        typeON(SignInInputPinPageLocator.Input_Pin_Field, pin);
    }
    public void checkErrorDialog() {
        waitUntilDisplayed(SignInInputPinPageLocator.ErrorDialog_Text);
    }
    public String getErrorDialogText() {
        return getText(SignInInputPinPageLocator.ErrorDialog_Text);
    }
    public void clickErrorDialogOkButton() {
        clickOn(SignInInputPinPageLocator.ErrorDialog_OK_Button);
    }
    public void clickBackButton() {
        clickOn(SignInInputPinPageLocator.Back_Button);
    }
    public void clickForgotPinButton() {
        clickOn(SignInInputPinPageLocator.ForgotPin_Button);
    }
}


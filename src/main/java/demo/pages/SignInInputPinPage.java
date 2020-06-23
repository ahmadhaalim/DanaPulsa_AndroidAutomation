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
    public void checkErrorDialog() {
        waitUntilDisplayed(GeneralLocator.ErrorDialog_Text);
    }
    public String getWarningMessagePopUpText() {
        return getText(GeneralLocator.ErrorDialog_Text);
    }
    public void clickWarningMessagePopUpOkButton() {
        clickOn(GeneralLocator.ErrorDialog_OK_Button);
    }
    public void clickBackButton() {
        clickOn(GeneralLocator.Back_Button);
    }
    public void clickForgotPinButton() {
        clickOn(SignInInputPinPageLocator.ForgotPin_Button);
    }
}


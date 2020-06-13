package demo.pages;

import demo.locator.SignInPageLocator;
import pageobjects.AndroidPageObject;

public class SignInPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(SignInPageLocator.DANA_Logo);
    }
    public void inputPhoneNumber(String phoneNumber) {
        typeON(SignInPageLocator.Input_PhoneNumber_Field, phoneNumber);
    }
    public void clickSignInButton() {
        clickOn(SignInPageLocator.SignIn_Button);
    }
    public void clickSignUpButton() {
        clickOn(SignInPageLocator.SignUp_Button);
    }
    public void checkErrorDialog() {
        waitUntilDisplayed(SignInPageLocator.ErrorDialog_Text);
    }
    public void clickErrorDialogOkButton() {
        clickOn(SignInPageLocator.ErrorDialog_OK_Button);
    }
    public String getErrorDialogText() {
        return getText(SignInPageLocator.ErrorDialog_Text);
    }

}

package demo.pages.nauval;

import demo.locator.nauval.SignInPageLocator;
import pageobjects.AndroidPageObject;

public class SignInPage implements SignInPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.waitUntilDisplayed(LOGIN_LABEL);
    }

    public void inputNumber(String number){
        pageObject.typeON(INPUT_NUMBER, number);
    }

    public void waitPIN(){
        pageObject.waitUntilDisplayed(PIN_LABEL);
    }

    public void inputPIN(String pin){
        pageObject.typeON(INPUT_PIN, pin);
    }

    public void signInButton(){
        pageObject.clickOn(SIGN_IN_BUTTON);
    }
}

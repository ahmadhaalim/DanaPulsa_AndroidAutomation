package demo.pages.forgotchangepin;

import demo.driver.AndroidDriverInstance;
import demo.locator.ForgotPinPageLocator;
import pageobjects.AndroidPageObject;

public class ConfirmPinPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(ForgotPinPageLocator.CONFIRM_PIN_LABEL);
    }

    public void inputConfirmPin(String pin) {
        typeON(ForgotPinPageLocator.CONFIRM_PIN_INPUT, pin);
    }

    public void clickFinish() {
        clickOn(ForgotPinPageLocator.FINISH_CONFIRM_BUTTON);
    }

    public boolean checkIfConfirmEnabled(){
        return checkIfEnabled(ForgotPinPageLocator.FINISH_CONFIRM_BUTTON);
    }

    public void clickBack() {
        clickOn(ForgotPinPageLocator.BACK_BUTTON);
    }

    public String getWarningMessage() {
        return AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.CONFIRM_PIN_WARNING).getText();
    }
}

package demo.pages.forgotchangepin;

import demo.driver.AndroidDriverInstance;
import demo.locator.ForgotPinPageLocator;
import pageobjects.AndroidPageObject;

public class NewPinPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(ForgotPinPageLocator.NEW_PIN_LABEL);
    }
    public void inputNewPin(String pin){
        typeON(ForgotPinPageLocator.NEW_PIN_INPUT,pin);
    }

    public void clickNext(){
        clickOn(ForgotPinPageLocator.NEXT_BUTTON);
    }

    public String getWarningMessage(){
        return AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.NEW_PIN_WARNING).getText();
    }
}

package demo.pages.loginHalim;

import demo.driver.AndroidDriverInstance;
import demo.locator.PinPageLocator;
import pageobjects.AndroidPageObject;

public class PinPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(PinPageLocator.PIN_INPUT_DUMMY);
    }
    public void inputPin(String pin){
        typeON(PinPageLocator.PIN_INPUT_DUMMY,pin);
    }
    public void clickForgot(){
        clickOn(PinPageLocator.FORGOT_BUTTON_DUMMY);
    }
    public String getWarningMessage(){
        //        ImageController imageController = new ImageController();
//        try {
//            return imageController.checkIfWarningDisplayed("tes.png");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return AndroidDriverInstance.androidDriver.findElement(PinPageLocator.DUMMY_PIN_WARNING).getText();
    }

}

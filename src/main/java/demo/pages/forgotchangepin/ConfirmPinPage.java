package demo.pages.forgotchangepin;

import demo.driver.AndroidDriverInstance;
import demo.imagecontroller.ImageController;
import demo.locator.ForgotPinPageLocator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import pageobjects.AndroidPageObject;

import java.time.Duration;

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

    public void setForPaste(String confirmpin){
        AndroidDriverInstance.androidDriver.setClipboardText(confirmpin);
    }

    public boolean tryToPaste(String deviceType) {

        AndroidElement element = AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.CONFIRM_PIN_INPUT);
        TouchAction action = new TouchAction(AndroidDriverInstance.androidDriver)
                .longPress(new LongPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofMillis(4000)))
                .release()
                .perform();
        System.out.println("LongPressed Tapped");
        ImageController imageController = new ImageController();
        try {
            return imageController.checkIfWarningDisplayed("paste-"+deviceType +".png");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getWarningMessage() { //String deviceType, String warningType
//        ImageController imageController = new ImageController();
//        try {
//            return imageController.checkIfWarningDisplayed("tes.png");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.CONFIRM_PIN_WARNING).getText();
    }
}

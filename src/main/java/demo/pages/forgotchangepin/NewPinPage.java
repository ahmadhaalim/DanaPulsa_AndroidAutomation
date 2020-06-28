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
        //        ImageController imageController = new ImageController();
//        try {
//            return imageController.checkIfWarningDisplayed("tes.png");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.NEW_PIN_WARNING).getText();
    }

    public void setForPaste(String newpin){
        AndroidDriverInstance.androidDriver.setClipboardText(newpin);
    }

    public boolean tryToPaste(String deviceType) {

        AndroidElement element = AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.NEW_PIN_INPUT);
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
}

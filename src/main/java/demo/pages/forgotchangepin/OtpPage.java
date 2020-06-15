package demo.pages.forgotchangepin;


import demo.driver.AndroidDriverInstance;
import demo.imagecontroller.ImageController;
import demo.locator.ForgotPinPageLocator;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class OtpPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(ForgotPinPageLocator.OTP_INPUT);
    }

    public void inputOTP(String otp) {
        typeON(ForgotPinPageLocator.OTP_INPUT, otp);
    }

    public void clickNextOtp() {
        clickOn(ForgotPinPageLocator.NEXT_BUTTON);
    }

    public boolean checkIfNextEnabled() {
        return checkIfEnabled(ForgotPinPageLocator.NEXT_BUTTON);
    }

    public void waitForResend() {
        WebDriverWait wait = new WebDriverWait(AndroidDriverInstance.androidDriver, 30);
    }

    public void clickResendOtp() {
        clickOn(ForgotPinPageLocator.RESEND_BUTTON);
    }

    public void setForPaste(){
        AndroidDriverInstance.androidDriver.setClipboardText("123456");
    }

    public void tryToPaste() {
        TouchAction action = new TouchAction(AndroidDriverInstance.androidDriver);
        AndroidElement element = AndroidDriverInstance.androidDriver.findElement(ForgotPinPageLocator.OTP_INPUT);
        action.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
                .perform ();
        System.out.println("LongPressed Tapped");
        ImageController imageController = new ImageController();
        try {
            imageController.checkIfWarningDisplayed("Capture.PNG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfResendEnabled(){
        return checkIfEnabled(ForgotPinPageLocator.RESEND_BUTTON);
    }






}

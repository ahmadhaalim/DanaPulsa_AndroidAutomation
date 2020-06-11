package demo.pages.forgotpin;


import demo.driver.AndroidDriverInstance;
import demo.locator.ForgotPinPageLocator;

import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

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



    public boolean checkIfResendEnabled(){
        return checkIfEnabled(ForgotPinPageLocator.RESEND_BUTTON);
    }






}

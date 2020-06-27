package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;

import demo.locator.SignUpConfirmPINPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class SignUpConfirmPINPage extends AndroidPageObject implements SignUpConfirmPINPageLocator {

    public boolean isOnPage() {
        List<AndroidElement> confirmPINText = androidDriver.findElements(TEXT_CONFIRM_PIN);
        return confirmPINText.size() > 0;
    }

    public void inputConfirmPIN(String confirmPIN) {
        typeON(EDIT_CONFIRM_PIN, confirmPIN);
    }

    public void tapFinishButton() {
        clickOn(BUTTON_FINISH);
    }

    public void tapBackButton() {
        clickOn(BUTTON_BACK);
    }

    public boolean finishButtonDisabled() {
        return !checkIfEnabled(BUTTON_FINISH);
    }

    public void pressAndHoldInputField() throws InterruptedException {
        WebElement pinField = androidDriver.findElement(EDIT_CONFIRM_PIN);
        pressHoldOnElement(pinField);
        Thread.sleep(1000);
    }
}

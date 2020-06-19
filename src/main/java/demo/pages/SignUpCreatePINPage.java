package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;

import demo.locator.SignUpCreatePINPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class SignUpCreatePINPage extends AndroidPageObject implements SignUpCreatePINPageLocator {

    public boolean isOnPage() {
        List<AndroidElement> createPINText = androidDriver.findElements(TEXT_CREATE_PIN);
        return createPINText.size() > 0;
    }

    public void inputPIN(String pin) {
        typeON(EDIT_CREATE_PIN, pin);
    }

    public void tapNextButton() {
        clickOn(BUTTON_NEXT);
    }

    public void tapBackButton() {
        clickOn(BUTTON_BACK);
    }

    public boolean nextButtonDisabled() {
        return !checkIfEnabled(BUTTON_NEXT);
    }

    public String getCustomViewText() {
        return androidDriver.findElement(EDIT_CREATE_PIN).getText();
    }

    public boolean warningMessageShown() throws IOException, URISyntaxException {
        String edTextWarning = getReferenceImageB64("create-pin-warning.png");
        return checkElementByImage(edTextWarning);
    }

    public String getWarningMessage() {
        return "PIN format is invalid";
    }

    public void pressAndHoldInputField() throws InterruptedException {
        WebElement pinField = androidDriver.findElement(EDIT_CREATE_PIN);
        pressHoldOnElement(pinField);
        Thread.sleep(1000);
    }
}

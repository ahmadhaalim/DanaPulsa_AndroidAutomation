package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;

import demo.locator.SignUpConfirmPINPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class SignUpConfirmPINPage extends AndroidPageObject implements SignUpConfirmPINPageLocator {

    public boolean isOnPage() {
        List<AndroidElement> confirmPINText = androidDriver.findElements(TEXT_CONFIRM_PIN);
        return confirmPINText.size() > 0;
    }

    public void inputConfirmPIN(String confirmPIN) {
        if (isOnPage()) {
            typeON(EDIT_CONFIRM_PIN, confirmPIN);
        }
    }

    public void tapFinishButton() {
        if (isOnPage()) {
            WebElement btnFinish = androidDriver.findElement(BUTTON_FINISH);
            if (btnFinish.isEnabled()) {
                btnFinish.click();
            }
        }
    }

    public void tapBackButton() {
        clickOn(BUTTON_BACK);
    }

    public boolean finishButtonDisabled() {
        return !checkIfEnabled(BUTTON_FINISH);
    }

    public boolean warningMessageShown() throws IOException, URISyntaxException {
        String edTextWarning = getReferenceImageB64("confirm-pin-warning.png");
        return checkElementByImage(edTextWarning);
    }

    public String getWarningMessage() {
        return "PIN doesn't match";
    }
}

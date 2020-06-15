package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;
import demo.locator.SignUpEmailPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class SignUpEmailPage extends AndroidPageObject implements SignUpEmailPageLocator {

    public boolean isOnPage() {
        List<AndroidElement> emailText = androidDriver.findElements(TEXT_EMAIL);
        return emailText.size() > 0;
    }

    public void inputEmail(String email) {
        if (isOnPage()) {
            typeON(EDIT_EMAIL, email);
        }
    }

    public void tapNextButton() {
        if (isOnPage()) {
            WebElement btnNext = androidDriver.findElement(BUTTON_NEXT);
            if (btnNext.isEnabled()) {
                btnNext.click();
            }
        }
    }

    public void tapBackButton() {
        clickOn(BUTTON_BACK);
    }

    public boolean nextButtonDisabled() {
        return !checkIfEnabled(BUTTON_NEXT);
    }

    public void pressAndHoldInputField() throws InterruptedException {
        WebElement emailField = androidDriver.findElement(EDIT_EMAIL);
        pressHoldOnElement(emailField);
        Thread.sleep(1000);
    }

    public void tapPaste() throws InterruptedException {
        WebElement emailField = androidDriver.findElement(EDIT_EMAIL);
        pasteToField(emailField);
        Thread.sleep(1000);
    }

    public String getFieldText() {
        return androidDriver.findElement(EDIT_EMAIL).getText();
    }

    public boolean warningMessageShown() throws IOException, URISyntaxException {
        String edTextWarning = getReferenceImageB64("email-warning.png");
        return checkElementByImage(edTextWarning);
    }

    public String getWarningMessage() {
        return "Email format is invalid";
    }
}

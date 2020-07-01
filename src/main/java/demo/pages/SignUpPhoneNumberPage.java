package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;
import demo.locator.SignUpPhoneNumberPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class SignUpPhoneNumberPage extends AndroidPageObject implements SignUpPhoneNumberPageLocator {

    public boolean isOnPage() {
        List<AndroidElement> phoneNumberText = androidDriver.findElements(TEXT_PHONE_NUMBER);
        return phoneNumberText.size() > 0;
    }

    public void inputPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 13) {
            clickOn(EDIT_PHONE_NUMBER);
            androidDriver.getKeyboard().sendKeys(phoneNumber);
            androidDriver.hideKeyboard();
        } else {
            typeOn(EDIT_PHONE_NUMBER, phoneNumber);
        }
    }

    public void tapNextButton() {
        clickOn(BUTTON_NEXT);
    }

    public void tapBackButton() {
        clickOn(BUTTON_BACK);
    }

    public boolean nextButtonEnabled() {
        return checkIfEnabled(BUTTON_NEXT);
    }

    public void pressAndHoldInputField() {
        WebElement phoneNumberField = androidDriver.findElement(EDIT_PHONE_NUMBER);
        pressHoldOnElement(phoneNumberField);
    }

    public String getFieldText() {
        return androidDriver.findElement(EDIT_PHONE_NUMBER).getText();
    }

    public boolean warningIconShown() {
        return waitUntilDisplayed(ICON_WARNING);
    }

    public String getWarningMessage() {
        return androidDriver.findElement(TEXT_WARNING).getText();
    }
}

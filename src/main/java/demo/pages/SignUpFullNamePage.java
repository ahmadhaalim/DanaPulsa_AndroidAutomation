package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;
import demo.locator.SignUpFullNamePageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class SignUpFullNamePage extends AndroidPageObject implements SignUpFullNamePageLocator {

    public boolean isOnPage() {
        List<AndroidElement> fullNameText = androidDriver.findElements(TEXT_FULL_NAME);
        return fullNameText.size() > 0;
    }

    public void inputFullName(String fullName) {
        typeON(EDIT_FULL_NAME, fullName);
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

    public void pressAndHoldInputField() throws InterruptedException {
        WebElement fullNameField = androidDriver.findElement(EDIT_FULL_NAME);
        pressHoldOnElement(fullNameField);
        Thread.sleep(1000);
    }

    public String getFieldText() {
        return androidDriver.findElement(EDIT_FULL_NAME).getText();
    }

    public boolean warningIconShown() {
        return waitUntilDisplayed(ICON_WARNING);
    }

    public String getWarningMessage() {
        return androidDriver.findElement(TEXT_WARNING).getText();
    }
}

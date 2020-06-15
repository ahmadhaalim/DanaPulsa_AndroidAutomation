package demo.pages;

import demo.locator.DialogPageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class DialogPage extends AndroidPageObject implements DialogPageLocator {

    public String getErrorMessage() {
        return androidDriver.findElement(TEXT_DIALOG_CONTENT).getText();
    }

    public boolean dialogIsShown() {
        List<AndroidElement> dialogTitle = androidDriver.findElements(TEXT_DIALOG_TITLE);
        return dialogTitle.size() > 0;
    }

    public void tapOKButton() {
        if (dialogIsShown()) {
            clickOn(BUTTON_DIALOG_OK);
        }
    }
}

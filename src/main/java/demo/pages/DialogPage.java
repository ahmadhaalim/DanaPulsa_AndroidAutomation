package demo.pages;

import demo.locator.DialogPageLocator;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class DialogPage extends AndroidPageObject implements DialogPageLocator {

    public String getErrorMessage() {
        return androidDriver.findElement(TEXT_DIALOG_CONTENT).getText();
    }

    public boolean dialogIsShown() {
        return waitUntilDisplayed(TEXT_DIALOG_TITLE);
    }

    public void tapOKButton() {
        clickOn(BUTTON_DIALOG_OK);
    }
}

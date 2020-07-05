package demo.pages;

import demo.locator.DialogPageLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class DialogPage extends AndroidPageObject implements DialogPageLocator {

    public String getDialogMessage() {
        return androidDriver.findElement(TEXT_DIALOG_CONTENT).getText();
    }

    public boolean dialogIsShown() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 35);
        return wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_DIALOG_TITLE)).isDisplayed();
    }

    public void tapOKButton() {
        clickOn(BUTTON_DIALOG_OK);
    }
}

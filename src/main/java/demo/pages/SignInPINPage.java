package demo.pages;

import demo.locator.SignInPINPageLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class SignInPINPage extends AndroidPageObject implements SignInPINPageLocator {

    public void inputPIN(String pin) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 35);
        wait.until(ExpectedConditions.presenceOfElementLocated(EDIT_PIN)).sendKeys(pin);
    }
}

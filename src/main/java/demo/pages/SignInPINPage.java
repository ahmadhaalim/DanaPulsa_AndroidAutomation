package demo.pages;

import demo.locator.SignInPINPageLocator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class SignInPINPage extends AndroidPageObject implements SignInPINPageLocator {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 35);
        boolean succeed = false;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_ENTER_PIN)).isDisplayed();
            succeed = true;
        } catch (TimeoutException ignore) { }
        return succeed;
    }

    public void inputPIN(String pin) {
        typeOn(EDIT_PIN, pin);
    }
}

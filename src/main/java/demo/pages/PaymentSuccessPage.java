package demo.pages;

import demo.locator.PaymentSuccessPageLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class PaymentSuccessPage extends AndroidPageObject implements PaymentSuccessPageLocator {

    public void tapBackToHome() {
        clickOn(BUTTON_TO_HOME);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 35);
        return wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_TITLE)).getText();
    }
}

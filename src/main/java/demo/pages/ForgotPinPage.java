package demo.pages;

import demo.locator.ForgotPinPageLocator;
import org.openqa.selenium.By;
import pageobjects.AndroidPageObject;

public class ForgotPinPage extends AndroidPageObject {

    public void isOnPage() {
        waitUntilDisplayed(ForgotPinPageLocator.InputOTP_Field);
    }
    public void clickBackButton() {
        clickOn(ForgotPinPageLocator.Back_Button);
    }
}

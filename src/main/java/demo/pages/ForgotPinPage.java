package demo.pages;

import demo.locator.ForgotPinPageLocator;
import org.openqa.selenium.By;
import pageobjects.AndroidPageObject;

public class ForgotPinPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(ForgotPinPageLocator.InputOTP_Field);
    }
}

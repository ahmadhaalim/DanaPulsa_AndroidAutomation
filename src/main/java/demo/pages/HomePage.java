package demo.pages;

import demo.locator.HomePageLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class HomePage extends AndroidPageObject implements HomePageLocator {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(USER_BALANCE, "Rp"));
        return wait.until(ExpectedConditions.presenceOfElementLocated(PROMOTION_BANNER_1)).isDisplayed();
    }

    public void tapProfileIcon() {
        clickOn(BUTTON_PROFILE);
    }
}

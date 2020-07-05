package demo.pages;

import demo.locator.HomePageLocator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class HomePage extends AndroidPageObject implements HomePageLocator {

    public int previousBalance;

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(PROMOTION_BANNER_1));
        }  catch (TimeoutException ign) {
            System.out.println("Failed displaying the Promotion Banner. It might be server problem.");
            System.out.println("Checking the visibility of user balance...");
        }
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(USER_BALANCE, "Rp"));
    }

    public void tapProfileIcon() {
        clickOn(BUTTON_PROFILE);
    }

    public void tapHistoryIcon() {
        clickOn(BUTTON_HISTORY);
    }

    public void tapVoucherIcon() {
        clickOn(BUTTON_VOUCHER);
    }

    public void tapHomeIcon() {
        clickOn(BUTTON_HOME);
    }

    public void tapMobileRechargeIcon() {
        previousBalance = getCurrentBalance();
        clickOn(BUTTON_MOBILE_RECHARGE);
    }

    public boolean directedToPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 35);
        boolean succeed = false;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_MOBILE_RECHARGE)).isDisplayed();
            succeed = true;
        } catch (TimeoutException ignore) { }
        return succeed;
    }

    public int getCurrentBalance() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(USER_BALANCE, "Rp"));

        String textBalance = androidDriver.findElement(USER_BALANCE).getText();
        textBalance = textBalance.replaceAll("\\D+","");
        return Integer.parseInt(textBalance);
    }
}

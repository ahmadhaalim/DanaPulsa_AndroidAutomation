package demo.pages;

import demo.locator.PaymentPageLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class PaymentPage extends AndroidPageObject implements PaymentPageLocator {

    WebDriverWait wait = new WebDriverWait(androidDriver, 35);

    public void tapPayButton() {
        clickOn(BUTTON_PAY);
    }

    public String totalPaidOnPayButton() {
        String total = wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_PAY)).getText();
        total = total.replaceAll("\\D+","");
        return total;
    }

    public void tapChangeVoucherButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_VOUCHER)).click();
    }

    public void tapWithoutVoucherButton() {
        clickOn(BUTTON_WITHOUT_VOUCHER);
    }

    public String getVoucherTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(VOUCHER_TITLE)).getText();
    }
}

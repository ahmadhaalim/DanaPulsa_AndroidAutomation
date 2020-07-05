package demo.pages;

import demo.locator.HistoryPageLocator;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class TransactionDetailPage implements HistoryPageLocator {

    public String getProduct() {
        return androidDriver.findElement(TRANSACTION_PRODUCT).getText();
    }

    public String getPhoneNumber() {
        String phoneNumber = androidDriver.findElement(TRANSACTION_PHONE).getText();
        phoneNumber = phoneNumber.replaceAll("\\D+","");
        return phoneNumber;
    }

    public String getStatus() {
        return androidDriver.findElement(TRANSACTION_STATUS).getText();
    }

    public String getTotalPaid() {
        String total = androidDriver.findElement(TRANSACTION_TOTAL).getText();
        total = total.replaceAll("\\D+","");
        return total;
    }

    public void tapBackButton() {
        androidDriver.findElement(BUTTON_BACK).click();
    }
}

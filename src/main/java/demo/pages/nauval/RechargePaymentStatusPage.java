package demo.pages.nauval;

import demo.driver.AndroidDriverInstance;
import demo.locator.nauval.RechargePaymentStatusPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentStatusPage implements RechargePaymentStatusPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.waitUntilDisplayed(TRANSACTION_STATUS_ICON);
    }

    public String statusPayment(){
        return AndroidDriverInstance.androidDriver.findElement(TRANSACTION_STATUS_VALUE).getText();
    }

    public void voucherDialog(){
        pageObject.waitUntilDisplayed(VOUCHER_DIALOG_TITLE);
    }

    public void confirmDialog(){
        pageObject.clickOn(OK_DIALOG_BUTTON);
    }

    public void backToHome(){
        pageObject.clickOn(BACK_TO_HOME_BUTTON);
    }
}

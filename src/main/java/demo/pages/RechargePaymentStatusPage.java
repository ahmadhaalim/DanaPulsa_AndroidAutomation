package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.RechargePaymentStatusPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentStatusPage implements RechargePaymentStatusPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(TRANSACTION_STATUS_ICON);
    }

    public String statusPayment(){
        pageObject.waitUntilDisplayed(TRANSACTION_RESULT);
        return AndroidDriverInstance.androidDriver.findElement(TRANSACTION_RESULT).getText();
    }

    public void voucherDialog(){
        pageObject.clickOn(OK_DIALOG_BUTTON);
    }

    public void confirmationButton(){
        pageObject.waitUntilDisplayed(OK_DIALOG_BUTTON);
        pageObject.clickOn(OK_DIALOG_BUTTON);
    }

    public void backToHome(){
        pageObject.clickOn(BACK_TO_HOME_BUTTON);
    }
}

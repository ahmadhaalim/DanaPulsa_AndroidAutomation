package demo.pages.nauval;

import demo.locator.nauval.RechargePaymentDetailPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentDetailPage implements RechargePaymentDetailPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(CHECKOUT_PRODUCT);
    }

    public boolean voucherUnavailable(){
        return pageObject.checkElement(SELECT_VOUCHER);
    }

    public boolean voucherAvailable(){
        return pageObject.checkElement(SELECT_VOUCHER);
    }

    public void pickVoucher(){
        pageObject.clickOn(SELECT_VOUCHER);
    }

    public void payButton(){
        pageObject.clickOn(PAY_BUTTON);
    }

    public void actionMenu(){
        pageObject.clickOn(TOOLBAR_MENU);
    }

    public void cancelButton(){
        pageObject.clickOn(CANCEL_BUTTON);
    }

    public void cancelDialog(){
        pageObject.waitUntilDisplayed(CANCEL_TRANSACTION_TITLE_DIALOG);
    }

    public void cancelPositive(){
        pageObject.clickOn(CANCEL_YES_BUTTON);
    }

}

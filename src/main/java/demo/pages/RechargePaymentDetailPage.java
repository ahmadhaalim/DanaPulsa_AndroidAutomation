package demo.pages;


import demo.locator.RechargePaymentDetailPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentDetailPage implements RechargePaymentDetailPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage() {
        return pageObject.checkIfDisplayed(CHECKOUT_PRODUCT);
    }

    public boolean voucherUnavailable() {
        return pageObject.checkIfEnabled(SELECT_VOUCHER);
    }

    public boolean voucherAvailable() {
        return pageObject.checkIfEnabled(SELECT_VOUCHER);
    }

    public void clickBackButton() {
        pageObject.clickOn(RechargePaymentDetailPageLocator.BACK_BUTTON);
    }

    public void clickYesButton() {
        pageObject.clickOn(RechargePaymentDetailPageLocator.CANCEL_YES_BUTTON);
    }

    public void pickVoucher() {
        pageObject.clickOn(SELECT_VOUCHER);
    }

    public void payButton() {
        pageObject.clickOn(PAY_BUTTON);
    }
}


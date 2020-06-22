package demo.pages.nauval;

import demo.locator.nauval.RechargePaymentDetailPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentDetailPage implements RechargePaymentDetailPageLocator {
    AndroidPageObject pageObject;

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(CHECKOUT_PRODUCT);
    }

    public boolean voucherUnavailable(){
        return pageObject.checkIfEnabled(SELECT_VOUCHER);
    }

    public boolean voucherAvailable(){
        return pageObject.checkIfEnabled(SELECT_VOUCHER);
    }

    public void pickVoucher(){
        pageObject.clickOn(SELECT_VOUCHER);
    }

    public void payButton(){
        pageObject.clickOn(PAY_BUTTON);
    }

}

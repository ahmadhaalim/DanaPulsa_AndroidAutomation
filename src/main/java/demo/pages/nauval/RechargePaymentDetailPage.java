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

}

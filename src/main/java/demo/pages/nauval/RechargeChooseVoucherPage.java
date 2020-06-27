package demo.pages.nauval;

import demo.locator.nauval.RechargeChooseVoucherPageLocator;
import pageobjects.AndroidPageObject;

public class RechargeChooseVoucherPage implements RechargeChooseVoucherPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(PHONE_IMAGE);
    }

    public void chooseCashback(String cashback){
       pageObject.multipleID(cashback, VOUCHER_TYPE);
    }

    public void chooseDiscount(String discount){
        pageObject.multipleID(discount, VOUCHER_TYPE);
    }

    public void noVoucher(){
        pageObject.clickOn(SELECT_NO_VOUCHER);
    }
}

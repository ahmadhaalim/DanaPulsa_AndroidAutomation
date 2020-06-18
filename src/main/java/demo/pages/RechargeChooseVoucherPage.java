package demo.pages;

import demo.locator.RechargeChooseVoucherPageLocator;
import pageobjects.AndroidPageObject;

public class RechargeChooseVoucherPage implements RechargeChooseVoucherPageLocator {
    AndroidPageObject pageObject;

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(PHONE_IMAGE);
    }

    public void chooseCashback(String cashback){
       pageObject.multipleID(cashback, VOUCHER_ITEM);
    }

    public void chooseDiscount(String discount){
        pageObject.multipleID(discount, VOUCHER_ITEM);
    }

    public void noVoucher(){
        pageObject.clickOn(SELECT_NO_VOUCHER);
    }
}

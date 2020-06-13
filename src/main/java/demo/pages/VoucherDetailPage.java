package demo.pages;

import demo.locator.VoucherDetailPageLocator;
import pageobjects.AndroidPageObject;

public class VoucherDetailPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(VoucherDetailPageLocator.Voucher_Amount);
    }
    public void clickBackButton(){
        clickOn(VoucherDetailPageLocator.Back_Button);
    }
    public String getVoucherAmount(){
        return getText(VoucherDetailPageLocator.Voucher_Amount);
    }
}

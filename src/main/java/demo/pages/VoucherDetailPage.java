package demo.pages;

import demo.locator.VoucherDetailPageLocator;
import pageobjects.AndroidPageObject;

public class VoucherDetailPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(VoucherDetailPageLocator.Back_Button);
    }
    public void clickBackButton(){
        clickOn(VoucherDetailPageLocator.Back_Button);
    }
    public String getVoucherValue(){
        return getText(VoucherDetailPageLocator.Voucher_Amount);
    }
    public String getWarningMessage() {
        return getText(VoucherDetailPageLocator.Warning_Message);
    }
}

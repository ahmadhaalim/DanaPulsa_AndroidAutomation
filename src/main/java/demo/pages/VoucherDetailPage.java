package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.VoucherDetailPageLocator;
import demo.locator.VoucherPageLocator;
import pageobjects.AndroidPageObject;

public class VoucherDetailPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(GeneralLocator.Screen_Title);
    }
    public String getVoucherName(){
        return getText(VoucherDetailPageLocator.VoucherDetail_Name);
    }
    public String getWarningMessage() {
        return getText(GeneralLocator.ErrorDialog_Text);
    }
}

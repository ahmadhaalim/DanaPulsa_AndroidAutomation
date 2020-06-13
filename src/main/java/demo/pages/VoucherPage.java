package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.HistoryPageLocator;
import demo.locator.VoucherPageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class VoucherPage extends AndroidPageObject{

    public boolean isOnPage(){
        return checkIfDisplayed(VoucherPageLocator.All_Button);
    }
    public void checkIfVoucherBannerIsDisplayed(){
        waitUntilDisplayed(VoucherPageLocator.Voucher_Banner);
    }
    public void clickOneOfVoucherBanner(){
        clickOn(VoucherPageLocator.Voucher_Banner);
    }
    public void chooseVoucherBanner(String kind) {
        List<AndroidElement> voucher = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Name);
        for (int i = 0; i < voucher.size(); i++) {
            if (kind.equalsIgnoreCase(voucher.get(i).getText())) {
                clickOn(VoucherPageLocator.Voucher_Banner);
            }
        }
    }
    public String getVoucherValue(String value){
        List<AndroidElement> amount = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Amount);
        String getAmount = "";
        for (int i = 0; i < amount.size(); i++) {
            if (value.equalsIgnoreCase(amount.get(i).getText())) {
                getAmount = getText(VoucherPageLocator.Voucher_Amount);
            }
        }
        return getAmount;
    }
    public void clickAllButton(){
        clickOn(VoucherPageLocator.All_Button);
    }
    public void clickDiscountButton(){
        clickOn(VoucherPageLocator.Discount_Button);
    }
    public void clickCashbackButton(){
        clickOn(VoucherPageLocator.Cashback_Button);
    }
    public String getWarningMessage(){
        return getText(VoucherPageLocator.Warning_Message);
    }

}

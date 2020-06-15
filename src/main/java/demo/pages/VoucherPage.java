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
    public void chooseVoucherBanner(String value) {
        List<AndroidElement> valueInBanner = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Amount);
        for (int i = 0; i < valueInBanner.size(); i++) {
            if (value.equalsIgnoreCase(valueInBanner.get(i).getText())) {
                clickOn(VoucherPageLocator.Voucher_Banner);
            }
        }
    }
    public String getVoucherValue(String value){
        List<AndroidElement> valueInBanner = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Amount);
        String getValue = "";
        for (int i = 0; i < valueInBanner.size(); i++) {
            if (value.equalsIgnoreCase(valueInBanner.get(i).getText())) {
                getValue = getText(VoucherPageLocator.Voucher_Amount);
            }
        }
        return getValue;
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

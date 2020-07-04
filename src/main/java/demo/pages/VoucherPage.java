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
    public boolean waitUntilVoucherBannerDisplayed(){
        return checkIfDisplayed(VoucherPageLocator.Voucher_Title);
    }

    public void chooseVoucherBanner(String value) {
        List<AndroidElement> title = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Name);
        for (AndroidElement androidElement : title) {
            if (value.equalsIgnoreCase(androidElement.getText())) {
                androidElement.click();
                break;
            }
        }
    }
    public String getVoucherName(String value){
        List<AndroidElement> valueInBanner = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Name);
        String getValue = "";
        for (AndroidElement androidElement : valueInBanner) {
            if (value.equalsIgnoreCase(androidElement.getText())) {
                getValue = androidElement.getText();
                break;
            }
        }
        return getValue;
    }
    public String getVoucherTitle(String value){
        List<AndroidElement> nameInBanner = AndroidDriverInstance.androidDriver
                .findElements(VoucherPageLocator.Voucher_Title);
        String getValue = "";
        for (AndroidElement androidElement : nameInBanner) {
            if (value.equalsIgnoreCase(androidElement.getText())) {
                getValue = androidElement.getText();
                break;
            }
        }
        return getValue;
    }
}

package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.MobileRechargePageLocator;
import demo.locator.VoucherPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import pageobjects.AndroidPageObject;

import java.util.List;

public class MobileRechargePage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(MobileRechargePageLocator.PhoneNumber_Field);
    }

    public void inputPhoneNumber(String phoneNumber) {
        typeON(MobileRechargePageLocator.PhoneNumber_Field,phoneNumber);
    }

    public boolean checkNominalPulsa(){
        return checkIfDisplayed(MobileRechargePageLocator.PULSA_PRICE);
    }

    public void choosePulsa(String pulsa) {
        List<AndroidElement> value = AndroidDriverInstance.androidDriver
                .findElements(MobileRechargePageLocator.PULSA_VALUE);
        for (AndroidElement androidElement : value) {
            if (pulsa.equalsIgnoreCase(androidElement.getText())) {
                androidElement.click();
                break;
            }
        }
    }

    public String checkPrice(String price) {
        List<AndroidElement> value = AndroidDriverInstance.androidDriver
                .findElements(MobileRechargePageLocator.PULSA_PRICE);
        String getPrice = "";
        for (AndroidElement androidElement : value) {
            if (price.equalsIgnoreCase(androidElement.getText())) {
                getPrice = androidElement.getText();
                break;
            }
        }
        return getPrice;
    }
}

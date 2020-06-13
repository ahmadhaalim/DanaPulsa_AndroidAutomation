package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.MobileRechargePageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import pageobjects.AndroidPageObject;

import java.util.List;

public class MobileRechargePage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(MobileRechargePageLocator.PhoneNumber_Field);
    }
    public void clickBackButton() {
        clickOn(MobileRechargePageLocator.Back_Button);
    }
    public void inputPhoneNumber(String phoneNumber) {
        typeON(MobileRechargePageLocator.PhoneNumber_Field,phoneNumber);
    }
    public void checkPulsaNominal() {
        waitUntilDisplayed(MobileRechargePageLocator.Pulsa_Choices);
    }
    public void choosePulsaNominal(String pulsaNominal) {
        List<AndroidElement> value = AndroidDriverInstance.androidDriver
                .findElements(MobileRechargePageLocator.Pulsa_Value);
        for (int i = 0; i < value.size(); i++) {
            if (pulsaNominal.equalsIgnoreCase(value.get(i).getText())) {
                clickOn(MobileRechargePageLocator.Pulsa_Choices);
            }
        }
    }
}

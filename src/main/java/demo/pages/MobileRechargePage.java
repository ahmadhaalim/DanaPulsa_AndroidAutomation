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
}

package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.RechargeChooseTopUpPageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class RechargeChooseTopUpPage implements RechargeChooseTopUpPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void chooseTopUpNominal(String nominal){
        List<AndroidElement> filters = AndroidDriverInstance.androidDriver.findElements(PULSA_CATALOG);
        for (AndroidElement filter : filters){
            if (filter.getText().equalsIgnoreCase(nominal)){
                filter.click();
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

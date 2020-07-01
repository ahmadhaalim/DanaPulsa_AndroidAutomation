package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.RechargeChooseTopUpPageLocator;
import demo.locator.RechargeInputPhoneNumberPageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class RechargeChooseTopUpPage implements RechargeChooseTopUpPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void chooseTopUpNominal(String nominal){
        pageObject.multipleID(nominal, PULSA_VALUE);
    }

    public boolean checkOperatorIcon(){
        return pageObject.checkElement(RechargeInputPhoneNumberPageLocator.PROVIDER_ICON);
    }

}

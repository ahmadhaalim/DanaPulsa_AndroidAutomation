package demo.pages.nauval;

import demo.locator.nauval.RechargeChooseTopUpPageLocator;
import pageobjects.AndroidPageObject;

public class RechargeChooseTopUpPage implements RechargeChooseTopUpPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void chooseTopUpNominal(String nominal){
       pageObject.multipleID(nominal,PULSA_CATALOG);
    }
}

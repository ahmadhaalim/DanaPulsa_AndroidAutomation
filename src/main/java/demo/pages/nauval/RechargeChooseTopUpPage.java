package demo.pages.nauval;

import demo.locator.nauval.RechargeChooseTopUpPageLocator;
import pageobjects.AndroidPageObject;

public class RechargeChooseTopUpPage implements RechargeChooseTopUpPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void chooseTopUpNominal(String nominal){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageObject.multipleID(nominal,PULSA_VALUE);
    }

    public boolean displayTopUp(){
        return pageObject.checkIfDisplayed(PROVIDER_ICON);
    }
}

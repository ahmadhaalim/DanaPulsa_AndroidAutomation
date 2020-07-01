package demo.pages.nauval;

import demo.locator.nauval.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage implements HomePageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();
    public int balanceInit = 0;
    public int balanceFinal = 0;

    public boolean onHomePage(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pageObject.waitUntilDisplayed(DANA_Balance);
    }

    public void chooseMobileRecharge(){
        pageObject.clickOn(MobileRecharge_Button);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseHistory(){
        pageObject.clickOn(History_Button);
    }

    public void chooseProfile(){
        pageObject.clickOn(Profile_Button);
    }

    public int getInitialBalance(){
       balanceInit = pageObject.toInteger(DANA_Balance);
       return balanceInit;
    }

    public int getFinalBalance(){
       balanceFinal = pageObject.toInteger(DANA_Balance);
       return balanceFinal;
    }
}

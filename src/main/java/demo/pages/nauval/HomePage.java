package demo.pages.nauval;

import demo.locator.nauval.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage implements HomePageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean onHomePage(){
        return pageObject.waitUntilDisplayed(Promotion_Banner);
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
}

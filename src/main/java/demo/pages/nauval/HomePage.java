package demo.pages.nauval;

import demo.locator.nauval.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage implements HomePageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean onHomePage(){
        return pageObject.checkIfDisplayed(Promotion_Banner);
    }

    public void chooseMobileRecharge(){
        pageObject.clickOn(MobileRecharge_Button);
    }
}

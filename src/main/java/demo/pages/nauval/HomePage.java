package demo.pages.nauval;

import demo.driver.AndroidDriverInstance;
import demo.locator.nauval.HomePageLocator;
import pageobjects.AndroidPageObject;

public class HomePage implements HomePageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

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

    public void getBalance(){
        String element = AndroidDriverInstance.androidDriver.findElement(DANA_Balance).getText();
        System.out.println(element);
    }
}

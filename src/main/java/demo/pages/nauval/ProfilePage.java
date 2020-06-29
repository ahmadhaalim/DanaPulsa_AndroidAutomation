package demo.pages.nauval;

import demo.locator.nauval.ProfilePageLocator;
import pageobjects.AndroidPageObject;

public class ProfilePage implements ProfilePageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void isOnPage(){
        pageObject.waitUntilDisplayed(Profile_Name);
    }

    public void signOut(){
        pageObject.clickOn(SignOut_Button);
    }

    public void confirmPositive(){
        pageObject.clickOn(SignOut_Positive);
    }

    public void confirmNegative(){
        pageObject.clickOn(SignOut_Negative);
    }
}

package demo.pages;

import demo.locator.ChangePinPageLocator;
import demo.locator.GeneralLocator;
import pageobjects.AndroidPageObject;

public class ChangePinPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(GeneralLocator.Back_Button);
    }
    public void clickBackButton(){
        clickOn(GeneralLocator.Back_Button);
    }
}

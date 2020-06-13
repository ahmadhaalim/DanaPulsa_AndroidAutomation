package demo.pages;

import demo.locator.ChangePinPageLocator;
import pageobjects.AndroidPageObject;

public class ChangePinPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(ChangePinPageLocator.ChangePin_Title);
    }
    public void clickBackButton(){
        clickOn(ChangePinPageLocator.Back_Button);
    }
}

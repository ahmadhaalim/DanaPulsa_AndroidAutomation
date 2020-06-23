package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class SignUpPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(SignUpPageLocator.InputName_Field);
    }
    public void clickBackButton() {
        clickOn(GeneralLocator.Back_Button);
    }
}

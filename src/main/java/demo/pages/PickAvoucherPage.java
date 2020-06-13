package demo.pages;

import demo.locator.PickAVoucherPageLocator;
import pageobjects.AndroidPageObject;

public class PickAvoucherPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(PickAVoucherPageLocator.Continue_Button);
    }
    public void clickContinueButton(){
        clickOn(PickAVoucherPageLocator.Continue_Button);
    }
}

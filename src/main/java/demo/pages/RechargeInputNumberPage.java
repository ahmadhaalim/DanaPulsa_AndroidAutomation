package demo.pages;


import demo.locator.RechargeInputPhoneNumberPageLocator;
import pageobjects.AndroidPageObject;

public class RechargeInputNumberPage implements RechargeInputPhoneNumberPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void inputNumber(String phoneNumber){
        pageObject.typeON(INPUT_PHONE_NUMBER, phoneNumber);
    }

    public void selectContact(){
        pageObject.clickOn(SELECT_CONTACT);
    }

    public void recentNumber(){
        pageObject.clickOn(RECENT_PHONE_NUMBER);
    }

    public void backButton(){
        pageObject.clickOn(BACK_BUTTON);
    }

    public boolean checkProviderIcon(){
        return pageObject.checkIfDisplayed(RechargeInputPhoneNumberPageLocator.RECENT_PROVIDER_ICON);
    }

}

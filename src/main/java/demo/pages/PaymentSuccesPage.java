package demo.pages;

import demo.locator.PaymentSuccesPageLocator;
import pageobjects.AndroidPageObject;

public class PaymentSuccesPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(PaymentSuccesPageLocator.Check_Icon);
    }
    public void clickBackToHomeButton(){
        clickOn(PaymentSuccesPageLocator.BackToHome_Button);
    }
    public String getTransactionId(){
        return getText(PaymentSuccesPageLocator.Transaction_Id);
    }
    public String getTransactionDate(){
        return getText(PaymentSuccesPageLocator.Transaction_Date);
    }
    public void clickYesButton() {clickOn(PaymentSuccesPageLocator.Yes_Button);}
}

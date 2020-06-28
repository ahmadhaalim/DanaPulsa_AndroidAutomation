package demo.pages;

import demo.locator.PaymentSuccesPageLocator;
import pageobjects.AndroidPageObject;

public class PaymentSuccesPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(PaymentSuccesPageLocator.Check_Icon);
    }
}

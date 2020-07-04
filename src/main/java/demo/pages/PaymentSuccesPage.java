package demo.pages;

import demo.locator.PaymentSuccesPageLocator;
import pageobjects.AndroidPageObject;

public class PaymentSuccesPage extends AndroidPageObject {

    public boolean isOnPage(){
        return checkIfDisplayed(PaymentSuccesPageLocator.TRANSACTION_STATUS_ICON);
    }

    public void clickBackToHomeButton() {
        clickOn(PaymentSuccesPageLocator.BACK_TO_HOME_BUTTON);
    }

    public String getId() {
        return getText(PaymentSuccesPageLocator.TRANSACTION_ID_VALUE);
    }

    public String getProduct() {
        return getText(PaymentSuccesPageLocator.TRANSACTION_PRODUCT_VALUE);
    }

    public String getPhone() {
        return getText(PaymentSuccesPageLocator.TRANSACTION_PHONE_VALUE);
    }

    public String getDate() {
        return getText(PaymentSuccesPageLocator.TRANSACTION_DATE_VALUE);
    }

    public String getStatus() {
        return getText(PaymentSuccesPageLocator.TRANSACTION_STATUS_VALUE);
    }
}

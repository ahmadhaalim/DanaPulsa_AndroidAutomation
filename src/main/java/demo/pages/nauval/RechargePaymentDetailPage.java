package demo.pages.nauval;

import demo.locator.nauval.RechargePaymentDetailPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentDetailPage implements RechargePaymentDetailPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public boolean isOnPage(){
        return pageObject.checkIfDisplayed(CHECKOUT_PRODUCT);
    }

    public void selectVoucher(String status){
        if (status.equalsIgnoreCase("unavailable")){

        }
        if (status.equalsIgnoreCase("available")){

        }
    }

    public void payButton(){
        pageObject.clickOn(PAY_BUTTON);
    }
}

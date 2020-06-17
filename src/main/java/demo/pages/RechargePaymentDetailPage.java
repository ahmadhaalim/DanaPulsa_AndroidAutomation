package demo.pages;


import demo.locator.RechargePaymentDetailPageLocator;
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

    public void clickBackButton() {pageObject.clickOn(RechargePaymentDetailPageLocator.BACK_BUTTON); }

    public void clickYesButton() { pageObject.clickOn(RechargePaymentDetailPageLocator.CANCEL_YES_BUTTON);
    }

    public void payButton(){
        pageObject.clickOn(PAY_BUTTON);
    }
}

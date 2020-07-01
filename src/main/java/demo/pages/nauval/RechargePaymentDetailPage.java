package demo.pages.nauval;

import demo.driver.AndroidDriverInstance;
import demo.locator.nauval.RechargePaymentDetailPageLocator;
import pageobjects.AndroidPageObject;

public class RechargePaymentDetailPage implements RechargePaymentDetailPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();
//    HomePage homePage = new HomePage();
    public int calcOrder = 0;

    public boolean isOnPage(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pageObject.checkIfDisplayed(CHECKOUT_PRODUCT);
    }

    public boolean voucherUnavailable(){
        return pageObject.checkElement(SELECT_VOUCHER);
    }

    public boolean voucherAvailable(){
        return pageObject.checkElement(SELECT_VOUCHER);
    }

    public void pickVoucher(){
        pageObject.clickOn(SELECT_VOUCHER);
    }

    public void payButton(){
        pageObject.clickOn(PAY_BUTTON);
    }

    public void actionMenu(){
        pageObject.clickOn(TOOLBAR_MENU);
    }

    public void cancelButton(){
        pageObject.clickOn(CANCEL_BUTTON);
    }

    public void cancelDialog(){
        pageObject.waitUntilDisplayed(CANCEL_TRANSACTION_TITLE_DIALOG);
    }

    public void cancelPositive(){
        pageObject.clickOn(CANCEL_YES_BUTTON);
    }

    public int getTotal(){
        calcOrder = pageObject.toInteger(CHECKOUT_TOTAL_VALUE);
        return calcOrder;
    }

//    public int calculate(){
//        int balance = homePage.balanceInit;
//        int total = getTotal();
//        return balance - total;
//    }

//    public int calcValue(){
//        calcOrder = calculate();
//        return calcOrder;
//    }
}

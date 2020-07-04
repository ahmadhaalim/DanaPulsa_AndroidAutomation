package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.LetsPayPageLocator;
import pageobjects.AndroidPageObject;

public class LetsPayPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(GeneralLocator.Screen_Title);
    }

    public String getTotalPrice() {
        return getText(LetsPayPageLocator.CHECKOUT_TOTAL_VALUE);
    }

    public void clickPayButton() {
        clickOn(LetsPayPageLocator.PAY_BUTTON);
    }

    public void clickChangeVoucherButton() {
        clickOn(LetsPayPageLocator.SELECT_VOUCHER);
    }

    public String getChoosedVoucher() {
        return getText(LetsPayPageLocator.CHECKOUT_VOUCHER_TITLE);
    }
}

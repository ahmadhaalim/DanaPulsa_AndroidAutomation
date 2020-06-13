package demo.pages;

import demo.locator.TransactionDetailPageLocator;
import pageobjects.AndroidPageObject;

public class TransactionDetailPage extends AndroidPageObject {
    public boolean isOnPage(){
        return checkIfDisplayed(TransactionDetailPageLocator.Transaction_Status);
    }
    public void clickBackButton(){
        clickOn(TransactionDetailPageLocator.Back_Button);
    }
    public String getTotalPrice(){
        return getText(TransactionDetailPageLocator.Total_Price);
    }
    public String getWarningMessage() {
        return getText(TransactionDetailPageLocator.Warning_Message);
    }
}

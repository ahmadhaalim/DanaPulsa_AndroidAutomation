package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.HistoryPageLocator;
import demo.locator.MobileRechargePageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class HistoryPage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(HistoryPageLocator.Completed_Tab);
    }
    public void waitUntilTransactionItemIsDiyplayed() {
        waitUntilDisplayed(HistoryPageLocator.Transaction_Item);
    }
    public String getWarningMessage() {
        return getText(HistoryPageLocator.Warning_Message);
    }
    public void clickCompletedTab() {
        clickOn(HistoryPageLocator.Completed_Tab);
    }

    public void clickInProgressTransaction(String price) {
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Price);
        for (int i = 0; i < itemPrice.size(); i++) {
            if (price.equalsIgnoreCase(itemPrice.get(i).getText())) {
                clickOn(HistoryPageLocator.Transaction_Item);
            }
        }
    }
    public void clickCompletedTransaction(String date) {
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Date);
        for (int i = 0; i < itemPrice.size(); i++) {
            if (date.equalsIgnoreCase(itemPrice.get(i).getText())) {
                clickOn(HistoryPageLocator.Transaction_Item);
            }
        }
    }

    public void clickOneOfCompletedTransaction(){
        clickOn(HistoryPageLocator.Transaction_Item);
    }

}

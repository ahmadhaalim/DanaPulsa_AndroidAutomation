package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.HistoryPageLocator;
import demo.locator.MobileRechargePageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class HistoryPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(HistoryPageLocator.Completed_Tab);
    }
    public void waitUntilTransactionItemIsDiyplayed() {
        waitUntilDisplayed(HistoryPageLocator.Transaction_Item);
    }
    public String getWarningMessage() {
        return getText(HistoryPageLocator.Warning_Message);
    }
    public void clickInProgressTab() { clickOn(HistoryPageLocator.InProgress_Tab);
    }
    public void clickCompletedTab() {
        clickOn(HistoryPageLocator.Completed_Tab);
    }
    public void clickOneCompletedTransaction(){clickOn(HistoryPageLocator.Transaction_Item);}

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
        List<AndroidElement> itemDate = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Date);
        List<AndroidElement> itemStatus = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.Transaction_Status);
        for (int i = 0; i < itemDate.size(); i++) {
            if (date.equalsIgnoreCase(itemDate.get(i).getText())) {
                if("Completed".equalsIgnoreCase(itemStatus.get(i).getText())) {
                    clickOn(HistoryPageLocator.Transaction_Item);
                }
            }
        }
    }

    public String checkInProgressTransactionStatus() {
        String status = "";
        List<AndroidElement> itemDate = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.Transaction_Status);
        for (int i = 0; i < itemDate.size(); i++) {
            if ("In Progress".equalsIgnoreCase(itemDate.get(i).getText())) {
                status = "In Progress";
            }
        }
        return status;
    }
}

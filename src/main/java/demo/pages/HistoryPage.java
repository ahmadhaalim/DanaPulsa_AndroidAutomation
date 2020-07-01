package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.HistoryPageLocator;
import demo.locator.MobileRechargePageLocator;
import demo.locator.PromotionListPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import pageobjects.AndroidPageObject;

import java.util.List;

public class HistoryPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(HistoryPageLocator.Completed_Tab);
    }

    public void waitUntilTransactionHistoryDisplayed() {
        waitUntilDisplayed(HistoryPageLocator.TransactionItem_Status);
    }
    public String getWarningMessage() {
        return getText(HistoryPageLocator.Warning_Message);
    }
    public void clickInProgressTab() { clickOn(HistoryPageLocator.InProgress_Tab);
    }
    public void clickCompletedTab() {
        clickOn(HistoryPageLocator.Completed_Tab);
    }

    public void clickOneTransactionHistory(String status, String price) throws InterruptedException {
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Price);
        List<AndroidElement> itemStatus = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Status);
        for (int i = 0; i < itemPrice.size(); i++) {
            if(status.equalsIgnoreCase(itemStatus.get(i).getText())){
                if (price.equalsIgnoreCase(itemPrice.get(i).getText())) {
                    itemPrice.get(i).click();
                }
            }
        }
    }
    public String getTransactionHistoryPrice(String status, String price) {
        String thePrice = "";
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Price);
        List<AndroidElement> itemStatus = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Status);
        for (int i = 0; i < itemPrice.size(); i++) {
            if (price.equalsIgnoreCase(itemPrice.get(i).getText())) {
                if(status.equalsIgnoreCase(itemStatus.get(i).getText())){
                    thePrice = itemPrice.get(i).getText();
                }
            }
        }
        return thePrice;
    }
    public String getTransactionHistoryStatus(String status, String price) {
        String theStatus = "";
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Price);
        List<AndroidElement> itemStatus = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Status);
        for (int i = 0; i < itemPrice.size(); i++) {
            if (price.equalsIgnoreCase(itemPrice.get(i).getText())) {
                if(status.equalsIgnoreCase(itemStatus.get(i).getText())){
                    theStatus = itemStatus.get(i).getText();
                }
            }
        }
        return theStatus;
    }
    public String getTransactionHistoryDateAndTime(String status, String price) {
        String theDate = "";
        List<AndroidElement> itemPrice = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Price);
        List<AndroidElement> itemStatus = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Status);
        List<AndroidElement> itemDate = AndroidDriverInstance.androidDriver
                .findElements(HistoryPageLocator.TransactionItem_Date);
        for (int i = 0; i < itemPrice.size(); i++) {
            if (price.equalsIgnoreCase(itemPrice.get(i).getText())) {
                if(status.equalsIgnoreCase(itemStatus.get(i).getText())){
                    theDate = itemDate.get(i).getText();
                }
            }
        }
        return theDate;
    }

}

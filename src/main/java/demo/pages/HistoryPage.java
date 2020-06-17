package demo.pages;

import demo.locator.HistoryPageLocator;
import pageobjects.AndroidPageObject;


public class HistoryPage extends AndroidPageObject {

    AndroidPageObject pageObject = new AndroidPageObject();

    public void clickInProgressTab() {clickOn(HistoryPageLocator.InProgress_Tab); }

    public void clickInProgressTransaction() {clickOn(HistoryPageLocator.Transaction_Item);
    }

}

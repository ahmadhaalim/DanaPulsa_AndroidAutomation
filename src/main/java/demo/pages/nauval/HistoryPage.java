package demo.pages.nauval;

import demo.driver.AndroidDriverInstance;
import demo.locator.nauval.HistoryPageLocator;
import pageobjects.AndroidPageObject;

public class HistoryPage implements HistoryPageLocator {
    AndroidPageObject pageObject = new AndroidPageObject();

    public void completedTab(){
        pageObject.clickOn(COMPLETED_TAB);
    }

    public void chooseHistory(){
        pageObject.clickOn(HISTORY_LIST);
    }

    public String checkStatus(){
        return AndroidDriverInstance.androidDriver.findElement(HISTORY_STATUS).getText();
    }

    public void backButton(){
        pageObject.clickOn(HISTORY_DETAIL_BACK);
    }
}

package demo.pages;

import demo.locator.HistoryPageLocator;
import pageobjects.AndroidPageObject;

public class HistoryPage extends AndroidPageObject implements HistoryPageLocator {

    public void tapCompletedTab() {
        clickOn(TAB_COMPLETED);
    }

    public void tapFirstTransaction() {
        clickOn(FIRST_TRANSACTION);
    }
}

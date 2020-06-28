package demo.pages;

import demo.locator.LetsPayPageLocator;
import pageobjects.AndroidPageObject;

public class LetsPayPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(LetsPayPageLocator.Total_Price);
    }
}

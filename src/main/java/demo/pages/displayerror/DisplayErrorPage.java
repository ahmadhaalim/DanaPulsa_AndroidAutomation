package demo.pages.displayerror;

import demo.driver.AndroidDriverInstance;
import demo.locator.DisplayErrorLocator;
import pageobjects.AndroidPageObject;

public class DisplayErrorPage extends AndroidPageObject {
    public boolean isDisplayed(){
        return checkIfDisplayed(DisplayErrorLocator.DISPLAY_TITLE);
    }

    public String getErrorText(){
        return AndroidDriverInstance.androidDriver.findElement(DisplayErrorLocator.DISPLAY_TEXT).getText();
    }
}

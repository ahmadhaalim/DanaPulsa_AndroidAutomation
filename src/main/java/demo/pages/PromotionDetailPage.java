package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.GeneralLocator;
import demo.locator.HomePageLocator;
import demo.locator.PromotionDetailPageLocator;
import demo.locator.PromotionListPageLocator;
import org.openqa.selenium.NoSuchElementException;
import pageobjects.AndroidPageObject;

public class PromotionDetailPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(GeneralLocator.Screen_Title);
    }
    public void clickBuyPulsaNowButton() {
        clickOn(PromotionDetailPageLocator.BuyPulsaNow_Button);
    }
    public String checkPromotionDetailTitle(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            AndroidDriverInstance.androidDriver.findElement(PromotionListPageLocator.PromotionBanner_Image);
            return "true";
        } catch (NoSuchElementException e) {
            return "false";
        }
    }
    public String getPromotionDetailTitle() {
        return getText(PromotionDetailPageLocator.PromotionDetail_Title);
    }
}

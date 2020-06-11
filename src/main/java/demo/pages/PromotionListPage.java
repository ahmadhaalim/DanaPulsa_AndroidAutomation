package demo.pages;

import demo.locator.PromotionDetailPageLocator;
import demo.locator.PromotionListPageLocator;
import pageobjects.AndroidPageObject;

public class PromotionListPage extends AndroidPageObject {
    public void isOnPage() {
        waitUntilDisplayed(PromotionListPageLocator.Promotion_Banner);
    }
    public void clickBackButton() {
        clickOn(PromotionListPageLocator.Back_Button);
    }
    public void clickPromotionBanner() {
        clickOn(PromotionListPageLocator.Promotion_Banner);
    }
    public String getWarningMessage() {
        return getText(PromotionListPageLocator.Warning_Message);
    }
}

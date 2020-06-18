package demo.pages;

import demo.locator.PromotionDetailPageLocator;
import pageobjects.AndroidPageObject;

public class PromotionDetailPage extends AndroidPageObject {

    public boolean isOnPage() {
        return checkIfDisplayed(PromotionDetailPageLocator.Promo_Title);
    }
    public void clickBackButton() {
        clickOn(PromotionDetailPageLocator.Back_Button);
    }
    public void clickBuyPulsaNowButton() {
        clickOn(PromotionDetailPageLocator.BuyPulsaNow_Button);
    }
    public String getWarningMessage() {
        return getText(PromotionDetailPageLocator.Warning_Message);
    }
}

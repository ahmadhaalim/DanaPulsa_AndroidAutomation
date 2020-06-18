package demo.pages;

import demo.locator.PromotionListPageLocator;
import pageobjects.AndroidPageObject;

public class PromotionListPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(PromotionListPageLocator.PromotionList_Title);
    }
    public boolean checkPromotionBanner(){
        return checkIfDisplayed(PromotionListPageLocator.Promotion_Banner);
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

package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.HomePageLocator;
import demo.locator.MobileRechargePageLocator;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AndroidPageObject;

import java.util.List;

public class HomePage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(HomePageLocator.DANA_Balance);
    }
    public void clickMobileRechargeButton() {
        clickOn(HomePageLocator.MobileRecharge_Button);
    }
    public void clickPromotionBanner() {
        List<AndroidElement> img = AndroidDriverInstance.androidDriver
                .findElements(HomePageLocator.PromotionBanner_Image);
        int a = 0;
        for (int i = 0; i < img.size(); i+=a) {
            if ("true".equalsIgnoreCase(img.get(i).getAttribute("enabled"))) {
                a+=1;
            } else {
                break;
            }
        }
        clickOn(HomePageLocator.PromotionBanner_Image);
    }
    public void clickViewAllButton() {
        clickOn(HomePageLocator.ViewAll_Button);
    }

    public String getWarningMessage() {
        return getText(HomePageLocator.GetPromotionBannerFailed_text);
    }
    public String getPromotionBannerTitle(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getText(HomePageLocator.PromotionBanner_Title);
    }
}

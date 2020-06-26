package demo.pages;

import demo.driver.AndroidDriverInstance;
import demo.locator.GeneralLocator;
import demo.locator.PromotionListPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import pageobjects.AndroidPageObject;

import java.util.List;

public class PromotionListPage extends AndroidPageObject {
    public boolean isOnPage() {
        return checkIfDisplayed(GeneralLocator.Screen_Title);
    }

    public void clickPromotionBanner() {
        clickOn(PromotionListPageLocator.PromotionBanner_Image);
    }

    public String checkPromotionBanner() {
        try {
            AndroidDriverInstance.androidDriver.findElement(PromotionListPageLocator.PromotionBanner_Image);
            return "true";
        } catch (NoSuchElementException e) {
            return "false";
        }
    }

    public String getPromotionBannerTitle() {
        return getText(PromotionListPageLocator.PromotionBanner_Title);
    }

    public String checkAllPromotionBanner() {
        checkIfDisplayed(PromotionListPageLocator.PromotionBanner_Image);

        List<AndroidElement> img = AndroidDriverInstance.androidDriver
                .findElements(PromotionListPageLocator.PromotionBanner_Image);
        int a = 0;
        String condition = "";
        for (int i = 0; i < img.size(); i += a) {
            if ("true".equalsIgnoreCase(img.get(i).getAttribute("enabled"))) {
                a += 1;
                condition = "true";
            } else {
                break;
            }
        }
        return condition;
    }

    public String getWarningMessage() {
        return getText(PromotionListPageLocator.ErrorMessage_Text);
    }
}

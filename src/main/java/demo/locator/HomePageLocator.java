package demo.locator;

import demo.pages.MobileRechargePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HomePageLocator{

    By DANA_Balance = MobileBy.id("tvBalance");
    By MobileRecharge_Button = MobileBy.id("btnMobileRecharge");
    By PromotionBanner_Image = MobileBy.id("ivPromotionItemImage");
    By PromotionBanner_Title = MobileBy.id("tvPromotionItemTitle");
    By ViewAll_Button = MobileBy.id("btnPromotionViewAll");
    By GetPromotionBannerFailed_text = MobileBy.id("tvErrorGetPromotion");
    By GetPromotionListFailed_text = MobileBy.id("tvErrorMessage");
}

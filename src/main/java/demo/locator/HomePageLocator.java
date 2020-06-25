package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HomePageLocator{

    By DANA_Balance = MobileBy.id("tvBalance");
    By Home_Button = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]");
    By MobileRecharge_Button = MobileBy.id("btnMobileRecharge");
    By Promotion_Banner = MobileBy.id("rvPromotion");
    By ViewAll_Button = MobileBy.id("btnPromotionViewAll");
    By GetPromotionBannerFailed_text = MobileBy.id("tvErrorGetPromotion");
    By GetPromotionListFailed_text = MobileBy.id("tvErrorMessage");
}

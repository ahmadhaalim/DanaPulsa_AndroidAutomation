package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PromotionListPageLocator {

    By Promotion_Banner = MobileBy.id("rvPromotion");
    By PromotionList_Title = MobileBy.id("tvActivityTitle");
    By Back_Button = MobileBy.id("btnBack");
    By Warning_Message = MobileBy.id("");
}

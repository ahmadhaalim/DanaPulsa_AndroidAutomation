package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PromotionDetailPageLocator {

    By Promo_Title = MobileBy.id("tvPromoTitle");
    By Back_Button = MobileBy.id("btnBack");
    By BuyPulsaNow_Button = MobileBy.id("btnBuyPulsa");
    By Warning_Message = MobileBy.id();
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HomePageLocator {

    // TextView
    By USER_BALANCE = MobileBy.id("tvBalance");

    // Button
    By BUTTON_MOBILE_RECHARGE = MobileBy.id("btnMobileRecharge");
    By BUTTON_PROFILE = MobileBy.id("navigation_profile");

    // Promotion Banner
    By PROMOTION_BANNER_1 = MobileBy.xpath("//androidx.cardview.widget.CardView[1]");
}

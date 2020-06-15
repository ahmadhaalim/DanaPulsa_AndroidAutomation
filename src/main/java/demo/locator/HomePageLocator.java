package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HomePageLocator{

    By DANA_Balance = MobileBy.id("tvBalance");
    By Home_Button = MobileBy.id("menuHome");
    By MobileRecharge_Button = MobileBy.id("btnMobileRecharge");
    By Promotion_Banner = MobileBy.id("rvPromotion");
    By ViewAll_Button = MobileBy.id("btnPromotionViewAll");
    By History_Button = MobileBy.id("menuHistory");
    By Voucher_Button = MobileBy.id("menuVoucher");
    By Profile_Button = MobileBy.id("menuProfile");
    By Warning_Message = MobileBy.id();
}

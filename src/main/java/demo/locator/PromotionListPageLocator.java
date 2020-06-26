package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PromotionListPageLocator {

    By PromotionBanner_Image = MobileBy.xpath("(//android.widget.ImageView[@content-desc=\"image promotion\"])[1]");
    By PromotionBanner_Title = MobileBy.id("tvPromotionItemTitle");
    By ErrorMessage_Text = MobileBy.id("tvErrorMessage");
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface MainPageLocator {
    By MOBILE_CHARGE_BUTTON = MobileBy.id("btnMobileRecharge");
    By PROFILE_MENU = MobileBy.id("navigation_profile");
}

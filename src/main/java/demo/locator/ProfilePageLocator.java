package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ProfilePageLocator {

    // Text View
    By TEXT_USER_NAME = MobileBy.id("tvUserName");
    By TEXT_USER_PHONE = MobileBy.id("tvUserPhone");
    By TEXT_USER_EMAIL = MobileBy.id("tvUserEmail");

    // Button
    By BUTTON_SIGN_OUT = MobileBy.id("btnUserSignOut");
}

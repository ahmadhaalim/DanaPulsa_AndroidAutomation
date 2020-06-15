package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ProfilePageLocator {
    By SIGN_OUT_MENU = MobileBy.id("btnUserSignOut");
    By CHANGE_PIN_MENU = MobileBy.id("btnUserChangePin");
}

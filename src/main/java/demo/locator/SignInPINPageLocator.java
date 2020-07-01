package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInPINPageLocator {

    // Text View
    By TEXT_ENTER_PIN = MobileBy.id("tvLoginLabelPin");

    // Custom View
    By EDIT_PIN = MobileBy.id("pinEntryLogin");
}

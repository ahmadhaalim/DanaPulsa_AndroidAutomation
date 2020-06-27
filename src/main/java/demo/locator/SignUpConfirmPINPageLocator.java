package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpConfirmPINPageLocator {

    // Text View
    By TEXT_CONFIRM_PIN = MobileBy.id("tvRegisterLabelConfirmPin");

    // Custom View
    By EDIT_CONFIRM_PIN = MobileBy.id("pinEntryConfirmRegister");

    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
    By BUTTON_FINISH = MobileBy.id("btnRegisterNext");
}

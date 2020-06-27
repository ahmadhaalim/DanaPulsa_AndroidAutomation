package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpEmailPageLocator {

    // Text View
    By TEXT_EMAIL = MobileBy.id("tvRegisterLabelEmail");
    By TEXT_WARNING = MobileBy.id("textinput_error");

    // Edit Text
    By EDIT_EMAIL = MobileBy.id("edtRegisterEmail");

    // Warning Icon
    By ICON_WARNING = MobileBy.id("text_input_end_icon");

    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

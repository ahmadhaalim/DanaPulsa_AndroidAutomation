package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpFullNamePageLocator {

    // Text View
    By TEXT_FULL_NAME = MobileBy.id("tvRegisterLabelFullName");
    By TEXT_WARNING = MobileBy.id("textinput_error");

    // Edit Text
    By EDIT_FULL_NAME = MobileBy.id("edtRegisterFullName");

    // Warning Icon
    By ICON_WARNING = MobileBy.id("text_input_end_icon");

    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpPhoneNumberPageLocator {

    // Text View
    By TEXT_PHONE_NUMBER = MobileBy.id("tvRegisterLabelPhone");
    By TEXT_WARNING = MobileBy.id("textinput_error");

    // Edit Text
    By EDIT_PHONE_NUMBER = MobileBy.id("edtRegisterPhone");

    // Warning Icon
    By ICON_WARNING = MobileBy.id("text_input_end_icon");

    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

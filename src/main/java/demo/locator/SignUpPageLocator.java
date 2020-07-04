package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpPageLocator {

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
    By BUTTON_FINISH = MobileBy.id("btnRegisterNext");

    // Text View
    By TEXT_FULL_NAME = MobileBy.id("tvRegisterLabelFullName");

    // Edit Text
    By EDIT_FULL_NAME = MobileBy.id("edtRegisterFullName");

    // Text View
    By TEXT_EMAIL = MobileBy.id("tvRegisterLabelEmail");

    // Edit Text
    By EDIT_EMAIL = MobileBy.id("edtRegisterEmail");

    // Text View
    By TEXT_CREATE_PIN = MobileBy.id("tvRegisterLabelPin");

    // Custom View
    By EDIT_CREATE_PIN = MobileBy.id("pinEntryRegister");

    // Text View
    By TEXT_CONFIRM_PIN = MobileBy.id("tvRegisterLabelConfirmPin");

    // Custom View
    By EDIT_CONFIRM_PIN = MobileBy.id("pinEntryConfirmRegister");



}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpPhoneNumberPageLocator {

    // Text View
    By TEXT_PHONE_NUMBER = MobileBy.id("tvRegisterLabelPhone");

    // Edit Text
    By EDIT_PHONE_NUMBER = MobileBy.id("edtRegisterPhone");

    // Button
    By BUTTON_BACK = MobileBy.id("btnRegisterBack");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

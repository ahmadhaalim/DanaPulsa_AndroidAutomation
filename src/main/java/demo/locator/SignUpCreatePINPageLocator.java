package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpCreatePINPageLocator {

    // Text View
    By TEXT_CREATE_PIN = MobileBy.id("tvRegisterLabelPin");

    // Custom View
    By EDIT_CREATE_PIN = MobileBy.id("pinRegister");

    // Button
    By BUTTON_BACK = MobileBy.id("btnRegisterBack");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

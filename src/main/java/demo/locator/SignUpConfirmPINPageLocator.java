package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpConfirmPINPageLocator {

    // Text View
    By TEXT_CONFIRM_PIN = MobileBy.id("tvRegisterLabelConfirmPin");

    // Custom View
    By EDIT_CONFIRM_PIN = MobileBy.id("pinRegisterConfirm");

    // Button
    By BUTTON_BACK = MobileBy.id("btnRegisterBack");
    By BUTTON_FINISH = MobileBy.id("btnRegisterFinish");
}

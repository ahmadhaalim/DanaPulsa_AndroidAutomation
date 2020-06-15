package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpEmailPageLocator {

    // Text View
    By TEXT_EMAIL = MobileBy.id("tvRegisterLabelEmail");

    // Edit Text
    By EDIT_EMAIL = MobileBy.id("edtRegisterEmail");

    // Button
    By BUTTON_BACK = MobileBy.id("btnRegisterBack");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

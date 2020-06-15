package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpFullNamePageLocator {

    // Text View
    By TEXT_FULL_NAME = MobileBy.id("tvRegisterLabelFullName");

    // Edit Text
    By EDIT_FULL_NAME = MobileBy.id("edtRegisterFullName");

    // Button
    By BUTTON_BACK = MobileBy.id("btnRegisterBack");
    By BUTTON_NEXT = MobileBy.id("btnRegisterNext");
}

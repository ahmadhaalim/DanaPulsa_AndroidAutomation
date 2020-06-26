package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PinPageLocator {
    By FORGOT_BUTTON_DUMMY = MobileBy.id("btnLoginForgotPin");
    By PIN_INPUT_DUMMY = MobileBy.id("pinEntryLogin");
    By DUMMY_PIN_WARNING = MobileBy.id(""); //KOSONG
}

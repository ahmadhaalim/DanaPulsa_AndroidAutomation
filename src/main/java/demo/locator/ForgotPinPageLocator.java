package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ForgotPinPageLocator {
    By InputOTP_Field = MobileBy.id("otpPIN");
    By Back_Button = MobileBy.id("btnPinBack");
}

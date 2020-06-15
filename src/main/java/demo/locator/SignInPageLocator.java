package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInPageLocator {

    // Button
    By BUTTON_SIGN_IN = MobileBy.id("btnLoginSignIn");
    By BUTTON_SIGN_UP = MobileBy.id("btnLoginSignUp");
}

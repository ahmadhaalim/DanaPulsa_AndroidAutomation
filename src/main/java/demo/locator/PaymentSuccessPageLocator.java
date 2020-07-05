package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PaymentSuccessPageLocator {

    // Text View
    By TEXT_TITLE = MobileBy.id("tvTransactionResult");

    // Button
    By BUTTON_TO_HOME = MobileBy.id("btnBackToHome");
}

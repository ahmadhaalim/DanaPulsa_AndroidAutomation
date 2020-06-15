package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface RechargeChooseTopUpPageLocator {
    // Text View
    By PULSA_VALUE = MobileBy.id("tvPulsaValue");
    By PULSA_PRICE = MobileBy.id("tvPulsaPrice");

    // Edit Text
    By INPUT_PHONE_NUMBER = MobileBy.id("edtPhoneNumber");

    // Button
    By SELECT_CONTACT = MobileBy.id("btnSelectContact");

    // Recycle View
    By PULSA_CATALOG = MobileBy.id("rvPulsaCatalog");
}

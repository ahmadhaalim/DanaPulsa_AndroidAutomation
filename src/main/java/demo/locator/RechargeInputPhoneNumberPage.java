package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface RechargeInputPhoneNumberPage {
    // Text View
    By RECENT_PHONE_NUMBER = MobileBy.id("tvRecentNumberPhone");
    By RECENT_DATE = MobileBy.id("tvRecentNumberDate");

    // Image View
    By RECENT_PROVIDER_ICON = MobileBy.id("ivRecentNumberProvider");

    // Edit Text
    By INPUT_PHONE_NUMBER = MobileBy.id("edtPhoneNumber");

    // Button
    By SELECT_CONTACT = MobileBy.id("btnSelectContact");
    By BACK_BUTTON = MobileBy.id("btnBack");

    // Recycle View
    By RECENT_NUMBER_ITEMS = MobileBy.id("rvRecentNumber");
}

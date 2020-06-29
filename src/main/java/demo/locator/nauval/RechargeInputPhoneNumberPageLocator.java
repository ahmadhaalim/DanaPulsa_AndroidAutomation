package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface RechargeInputPhoneNumberPageLocator {
    // Text View
    By RECENT_PHONE_NUMBER = MobileBy.id("tvRecentNumberPhone");
    By RECENT_DATE = MobileBy.id("tvRecentNumberDate");
    By INVALID_INPUT = MobileBy.id("textinput_error");

    // Image View
    By RECENT_PROVIDER_ICON = MobileBy.id("ivRecentNumberProvider");

    // Edit Text
    By INPUT_PHONE_NUMBER = MobileBy.id("edtPhoneNumber");

    // Button
    By SELECT_CONTACT = MobileBy.id("btnSelectContact");
    By BACK_BUTTON = MobileBy.id("btnBack");

    // Recycle View
    By RECENT_NUMBER_ITEMS = MobileBy.xpath("//androidx.cardview.widget.CardView[1]");
}
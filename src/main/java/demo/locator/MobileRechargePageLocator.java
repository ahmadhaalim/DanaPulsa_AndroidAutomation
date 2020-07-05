package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface MobileRechargePageLocator {

    // Edit Text
    By EDIT_PHONE_NUMBER = MobileBy.id("edtPhoneNumber");

    // Card View
    By PULSA_CONTAINER = MobileBy.xpath("//androidx.cardview.widget.CardView");

    By PULSA_NOMINAL = MobileBy.id("tvPulsaValue");
    By PULSA_PRICE = MobileBy.id("tvPulsaPrice");
}

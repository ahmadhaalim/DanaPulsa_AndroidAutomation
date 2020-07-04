package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface MobileRechargePageLocator {
    By PhoneNumber_Field = MobileBy.id("edtPhoneNumber");
    By PULSA_VALUE = MobileBy.id("tvPulsaValue");
    By PULSA_PRICE = MobileBy.id("tvPulsaPrice");
}

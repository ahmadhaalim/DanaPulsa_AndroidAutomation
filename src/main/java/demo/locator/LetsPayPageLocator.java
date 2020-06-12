package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface LetsPayPageLocator {
    By Back_Button = MobileBy.id("btnBack");
    By Pay_Button = MobileBy.id("btnCheckoutPay");
    By Total_Price = MobileBy.id("tvCheckoutTotalValue");
    By Yes_Button = MobileBy.id("btnDialogPositive");
}

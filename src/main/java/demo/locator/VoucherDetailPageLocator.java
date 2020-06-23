package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface VoucherDetailPageLocator {
    By Voucher_Amount = MobileBy.id("tvVoucherAmount");
    By Back_Button = MobileBy.id("");
    By VoucherTitle_Header = MobileBy.id("tvVoucherName");
    By Warning_Message = MobileBy.id("");
}

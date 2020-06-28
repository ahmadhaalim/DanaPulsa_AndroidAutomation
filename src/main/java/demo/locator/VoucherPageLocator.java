package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface VoucherPageLocator {
    By Voucher_Title = MobileBy.id("tvVoucherInfo");
    By Voucher_Name = MobileBy.id("tvVoucherName");
    By Voucher_Amount = MobileBy.id("tvVoucherAmount");
    By Voucher_Date = MobileBy.id("tvVoucherExpireDate");
    By All_Button = MobileBy.id("chipAllVoucher");
    By Discount_Button = MobileBy.id("chipDiscountVoucher");
    By Cashback_Button = MobileBy.id("chipCashbackVoucher");
    By Warning_Message = MobileBy.id("tvLoadVoucher");
}

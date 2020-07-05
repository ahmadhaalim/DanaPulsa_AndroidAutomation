package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PaymentPageLocator {

    // Text View
    By VOUCHER_TITLE = MobileBy.id("tvVoucherTitle");
    By TRANSACTION_PRICE = MobileBy.id("tvTransactionPriceValue");
    By TRANSACTION_PROMO = MobileBy.id("tvTransactionPromoValue");
    By TRANSACTION_TOTAL = MobileBy.id("tvTransactionTotalValue");

    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
    By BUTTON_VOUCHER = MobileBy.id("btnVoucherAction");
    By BUTTON_OPTIONS = MobileBy.AccessibilityId("More options");
    By BUTTON_CANCEL = MobileBy.id("content");
    By BUTTON_PAY = MobileBy.id("btnPay");

    // Choose Voucher Page
    // Button
    By BUTTON_WITHOUT_VOUCHER = MobileBy.id("btnSelectWithoutVoucher");

}

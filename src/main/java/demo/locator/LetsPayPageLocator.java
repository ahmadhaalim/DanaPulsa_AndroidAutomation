package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface LetsPayPageLocator {
    // Text View
    By CHECKOUT_PRODUCT = MobileBy.id("tvCheckoutProduct");
    By CHECKOUT_VOUCHER_TITLE = MobileBy.id("tvVoucherTitle");
    By CHECKOUT_VOUCHER_SUBTITLE = MobileBy.id("tvCheckoutVoucherSubtitle");
    By CHECKOUT_VOUCHER_ACTION = MobileBy.id("tvCheckoutVoucherAction");

    By CHECKOUT_PRICE_LABEL = MobileBy.id("tvCheckoutPriceLabel");
    By CHECKOUT_PRICE_VALUE = MobileBy.id("tvCheckoutPriceValue");

    By CHECKOUT_PROMO_LABEL = MobileBy.id("tvCheckoutPromoLabel");
    By CHECKOUT_PROMO_VALUE = MobileBy.id("tvCheckoutPromoValue");

    By CHECKOUT_TOTAL_LABEL = MobileBy.id("tvCheckoutTotalLabel");
    By CHECKOUT_TOTAL_VALUE = MobileBy.id("tvTransactionTotalValue");

    By CANCEL_TRANSACTION_TITLE_DIALOG = MobileBy.id("tvDialogTitle");
    By CANCEL_TRANSACTION_DIALOG_CONTENT = MobileBy.id("tvDialogContent");

    // Button
    By TOOLBAR_MENU = MobileBy.xpath("//android.widget.ImageView[@content-desc='More options']");
    By BACK_BUTTON = MobileBy.AccessibilityId("Navigate up");
    By SELECT_VOUCHER = MobileBy.id("btnVoucherAction");
    By PAY_BUTTON = MobileBy.id("btnPay");
    By CANCEL_BUTTON = MobileBy.id("content");

    By CANCEL_YES_BUTTON = MobileBy.id("btnDialogPositive");
    By CANCEL_NO_BUTTON = MobileBy.id("btnDialogNegative");
}

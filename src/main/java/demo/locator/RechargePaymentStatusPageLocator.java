package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface RechargePaymentStatusPageLocator {
    // Text View
    By TRANSACTION_RESULT = MobileBy.id("tvTransactionResult");

    By TRANSACTION_ID_LABEL = MobileBy.id("tvTransactionIdLabel");
    By TRANSACTION_ID_VALUE = MobileBy.id("tvTransactionIdValue");
    By TRANSACTION_PRODUCT_LABEL = MobileBy.id("tvTransactionProductLabel");
    By TRANSACTION_PRODUCT_VALUE = MobileBy.id("tvTransactionProductValue");
    By TRANSACTION_PHONE_LABEL = MobileBy.id("tvTransactionPhoneLabel");
    By TRANSACTION_PHONE_VALUE = MobileBy.id("tvTransactionPhoneValue");
    By TRANSACTION_DATE_LABEL = MobileBy.id("tvTransactionDateLabel");
    By TRANSACTION_DATE_VALUE = MobileBy.id("tvTransactionDateValue");
    By TRANSACTION_STATUS_LABEL = MobileBy.id("tvTransactionStatusLabel");
    By TRANSACTION_STATUS_VALUE = MobileBy.id("tvTransactionStatusValue");

    By VOUCHER_DIALOG_TITLE = MobileBy.id("tvDialogTitle");
    By VOUCHER_DIALOG_CONTENT = MobileBy.id("tvDialogContent");

    By TRANSACTION_HISTORY_INFO = MobileBy.id("tvTransactionHistoryInformation");

    // Image View
    By TRANSACTION_STATUS_ICON = MobileBy.id("ivTransactionIcon");

    // Button
    By BACK_TO_HOME_BUTTON = MobileBy.id("btnBackToHome");
    By OK_DIALOG_BUTTON = MobileBy.id("btnDialogPositive");

}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HistoryPageLocator {

    // Button
    By TAB_IN_PROGRESS = MobileBy.AccessibilityId("In Progress");
    By TAB_COMPLETED = MobileBy.AccessibilityId("Completed");

    // Card View
    By FIRST_TRANSACTION = MobileBy.xpath("//androidx.cardview.widget.CardView[1]");

    // TRANSACTION DETAIL
    // Text View
    By TRANSACTION_PRODUCT = MobileBy.id("tvTransactionProductValue");
    By TRANSACTION_PHONE = MobileBy.id("tvTransactionPhoneValue");
    By TRANSACTION_STATUS = MobileBy.id("tvTransactionStatusValue");
    By TRANSACTION_TOTAL = MobileBy.id("tvTransactionTotalValue");
    // Button
    By BUTTON_BACK = MobileBy.AccessibilityId("Navigate up");
}

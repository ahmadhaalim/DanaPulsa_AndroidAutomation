package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HistoryPageLocator {
    By IN_PROGRESS_TAB = MobileBy.AccessibilityId("In Progress");
    By COMPLETED_TAB = MobileBy.AccessibilityId("Completed");
    By HISTORY_LIST = MobileBy.xpath("//androidx.cardview.widget.CardView[1]");
    By HISTORY_PRICE = MobileBy.id("tvHistoryItemPrice");
    By HISTORY_STATUS = MobileBy.id("tvHistoryItemStatus");
    By HISTORY_DETAIL_BACK = MobileBy.AccessibilityId("Navigate up");
    By TRANSACTION_STATUS_VALUE = MobileBy.id("tvTransactionStatusValue");
}

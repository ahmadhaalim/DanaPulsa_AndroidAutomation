package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HistoryPageLocator {

    By InProgress_Tab = MobileBy.AccessibilityId("In Progress");
    By Completed_Tab = MobileBy.AccessibilityId("Completed");
    By TransactionItem_Price = MobileBy.id("tvHistoryItemPrice");
    By TransactionItem_Date = MobileBy.id("tvHistoryItemDate");
    By TransactionItem_Status = MobileBy.id("tvHistoryItemStatus");
    By Warning_Message = MobileBy.id("tvLoadMessage");
    By TransactionDetail_Status = MobileBy.id("tvTransactionStatusValue");
    By TransactionDetail_Price = MobileBy.id("tvTransactionTotalValue");
    By TransactionDetail_Date = MobileBy.id("tvTransactionDateValue");
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HistoryPageLocator {

    By InProgress_Tab = MobileBy.id("");
    By Completed_Tab = MobileBy.id("");
    By Transaction_Item = MobileBy.id("rvHistory");
    By TransactionItem_Price = MobileBy.id("tvHistoryItemPrice");
    By TransactionItem_Date = MobileBy.id("tvHistoryItemDate");
    By Warning_Message = MobileBy.id("");
    By Transaction_Status = MobileBy.id("tvHistoryItemStatus");
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HistoryPageLocator {

    By InProgress_Tab = MobileBy.xpath("\t//android.widget.LinearLayout[@content-desc=\"In Progress\"]");
    By Completed_Tab = MobileBy.xpath("\t//android.widget.LinearLayout[@content-desc=\"Completed\"]");
    By Transaction_Item = MobileBy.id("rvHistory");
    By TransactionItem_Price = MobileBy.id("tvHistoryItemPrice");
    By TransactionItem_Date = MobileBy.id("tvHistoryItemDate");
    By Warning_Message = MobileBy.id("tvLoadMessage");
    By Transaction_Status = MobileBy.id("tvHistoryItemStatus");
}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface TransactionDetailPageLocator {
    By Back_Button = MobileBy.id();
    By Transaction_Status = MobileBy.id("tvTransactionStatusValue");
    By Total_Price = MobileBy.id("tvTransactionTotalValue");
    By Warning_Message = MobileBy.id();
}

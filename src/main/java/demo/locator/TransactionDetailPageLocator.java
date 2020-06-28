package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface TransactionDetailPageLocator {
    By TransactionDetail_Header = MobileBy.id("tvTransactionIdLabel");
    By Transaction_Status = MobileBy.id("tvTransactionStatusValue");
    By Transaction_Price = MobileBy.id("tvTransactionTotalValue");
    By Transaction_ID = MobileBy.id("tvTransactionIdValue");
    By Transaction_Product = MobileBy.id("tvTransactionProductLabel");
    By Transaction_Date = MobileBy.id("tvTransactionDateValue");
    By Transaction_Phone = MobileBy.id("tvTransactionPhoneValue");
}

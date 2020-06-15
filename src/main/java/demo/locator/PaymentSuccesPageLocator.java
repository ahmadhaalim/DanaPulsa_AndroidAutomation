package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PaymentSuccesPageLocator {
    By BackToHome_Button = MobileBy.id("btnBackToHome");
    By Transaction_Id = MobileBy.id("tvTransactionIdValue");
    By Transaction_Date = MobileBy.id("tvTransactionDateValue");
    By Transaction_Status = MobileBy.id("tvTransactionStatusValue");
    By Transaction_Phone = MobileBy.id("tvTransactionPhoneValue");
    By Transaction_Product = MobileBy.id("tvTransactionProductValue");
    By Check_Icon = MobileBy.id("ivTransactionIcon");
    By Yes_Button = MobileBy.id("btnDialogPositive");

}

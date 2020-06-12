package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface PaymentSuccesPageLocator {
    By BackToHome_Button = MobileBy.id("btnBackToHome");
    By Transaction_Id = MobileBy.id("tvTransactionIdValue");
    By Transaction_Date = MobileBy.id("tvTransactionDateValue");
    By Check_Icon = MobileBy.id("ivTransactionIcon");

}

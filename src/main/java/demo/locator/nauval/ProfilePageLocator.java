package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ProfilePageLocator {
    By SignOut_Button = MobileBy.id("btnUserSignOut");
    By SignOut_Positive = MobileBy.id("btnDialogPositive");
    By SignOut_Negative = MobileBy.id("btnDialogNegative");
    By Profile_Name = MobileBy.id("tvUserName");
}

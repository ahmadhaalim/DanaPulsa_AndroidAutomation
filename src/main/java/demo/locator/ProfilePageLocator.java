package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ProfilePageLocator {

    By Name_Text = MobileBy.id("tvUserName");
    By Phone_Text = MobileBy.id("tvUserPhone");
    By Email_Text = MobileBy.id("tvUserEmail");
    By ChangePin_Button = MobileBy.id("btnUserChangePin");
    By SignOut_Button = MobileBy.id("btnUserSignOut");
    By Warning_Message = MobileBy.id();
}

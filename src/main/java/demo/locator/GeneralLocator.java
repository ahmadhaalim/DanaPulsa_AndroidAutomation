package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface GeneralLocator {
    By ErrorDialog_Text = MobileBy.id("tvDialogContent");
    By ErrorDialog_OK_Button = MobileBy.id("btnDialogPositive");
    By TOAST_POPUP = MobileBy.xpath("//android.widget.Toast[1]");
    By Back_Button = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
}

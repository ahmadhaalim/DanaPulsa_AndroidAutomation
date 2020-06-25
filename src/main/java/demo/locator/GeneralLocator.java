package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface GeneralLocator {
    By ErrorDialog_Text = MobileBy.id("tvDialogContent");
    By ErrorDialog_OK_Button = MobileBy.id("btnDialogPositive");
    By TOAST_POPUP = MobileBy.xpath("/hierarchy/android.widget.Toast");
    By Back_Button = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    By ErrorMessage_Text = MobileBy.id("textinput_error");
    By ProfileMenu_Button = MobileBy.id("navigation_profile");
    By VoucherMenu_Button = MobileBy.id("navigation_voucher");
    By HistoryMenu_Button = MobileBy.id("navigation_history");
    By HomeMenu_Button = MobileBy.id("navigation_home");
    By Screen_Title = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n");

}

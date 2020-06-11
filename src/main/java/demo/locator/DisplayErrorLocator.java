package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface DisplayErrorLocator {
    By DISPLAY_TITLE = MobileBy.id("tvDialogTitle");
    By DISPLAY_TEXT = MobileBy.id("tvDialogContent");
    By BUTTON_OK = MobileBy.id("btnDialogPositive");
}

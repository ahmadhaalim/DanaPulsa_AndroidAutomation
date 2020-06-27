package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface DialogPageLocator {

    // Text View
    By TEXT_DIALOG_TITLE = MobileBy.id("tvDialogTitle");
    By TEXT_DIALOG_CONTENT = MobileBy.id("tvDialogContent");

    // Button
    By BUTTON_DIALOG_OK = MobileBy.id("btnDialogPositive");
    By BUTTON_DIALOG_NO = MobileBy.id("btnDialogNegative");
}

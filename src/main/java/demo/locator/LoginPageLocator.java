package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface LoginPageLocator {
    By DUMMY_DANA_LOGO = MobileBy.id("ivLoginLogo");
    By DUMMY_INPUT_NOMOR = MobileBy.id("edtLoginPhone");
    By DUMMY_CLICK_SIGNIN = MobileBy.id("btnLoginSignIn");

}

package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInPageLocator {

    By DANA_Logo = MobileBy.id("ivLoginLogo");
    By Input_PhoneNumber_Field = MobileBy.id("edtLoginPhone");
    By SignIn_Button = MobileBy.id("btnLoginSignIn");
    By SignUp_Button = MobileBy.id("btnLoginSignUp");
}

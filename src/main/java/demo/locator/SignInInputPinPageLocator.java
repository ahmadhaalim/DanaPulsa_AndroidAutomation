package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInInputPinPageLocator {

    By EnterYourPin_Text = MobileBy.id("tvLoginLabelPin");
    By Input_Pin_Field = MobileBy.id("pinEntryLogin");
    By ForgotPin_Button = MobileBy.id("btnLoginForgotPin");

}

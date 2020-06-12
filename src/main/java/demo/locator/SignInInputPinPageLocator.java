package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignInInputPinPageLocator {

    By Back_Button = MobileBy.id("btnLoginPinBack");
    By EnterYourPin_Text = MobileBy.id("tvLoginLabelPin");
    By Input_Pin_Field = MobileBy.id("pinLogin");
    By ForgotPin_Button = MobileBy.id("btnLoginForgotPin");
    By ErrorDialog_Text = MobileBy.id("tvDialogContent");
    By ErrorDialog_OK_Button = MobileBy.id("btnDialogPositive");
}

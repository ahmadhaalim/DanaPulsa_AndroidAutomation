package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface SignUpPageLocator {

    By InputName_Field = MobileBy.id("edtRegisterFullName");
    By Back_Button = MobileBy.id("btnRegisterBack");
}

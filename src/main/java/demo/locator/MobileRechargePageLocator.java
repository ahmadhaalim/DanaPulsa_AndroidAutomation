package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface MobileRechargePageLocator {

    By PhoneNumber_Field = MobileBy.id("edtPhoneNumber");
    By Back_Button = MobileBy.id("btnBack");
    By Pulsa_Choices = MobileBy.id("rvPulsaCatalog");
    By Pulsa_Value = MobileBy.id("tvPulsaValue");


}

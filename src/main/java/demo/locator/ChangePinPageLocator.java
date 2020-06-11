package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ChangePinPageLocator {


    //SAMA DENGAN FORGOT OTP
    //BIAR TIDAK PERLU IMPORT LEBIH DARI 1 INTERFACE.
    By CHANGE_PIN_OTP_LABEL = MobileBy.id("tvOtpConfirmLabel");
    By PHONENUMBER_OTP_LABEL = MobileBy.id("tvOtpConfirmPhone");
    By OTP_INPUT = MobileBy.id("otpPIN"); //INPUT OTP
    By RESEND_LABEL = MobileBy.id("tvResendOtpLabel");
    By RESEND_BUTTON = MobileBy.id("btnResendOtp");
    By NEXT_BUTTON = MobileBy.id("btnPinNext");
    By CHANGE_PIN_TITLE = MobileBy.id("tvActivityTitle");
    By BACK_BUTTON = MobileBy.id("btnPinBack");



    By CHANGE_NEW_PIN_LABEL = MobileBy.id("tvPinLabel");
    By CHANGE_NEW_PIN_INPUT = MobileBy.id("pinEntryNewPin"); //INPUT NEW PIN


    By CHANGE_CONFIRM_PIN_LABEL = MobileBy.id("tvPinConfirmLabel");
    By CHANGE_CONFIRM_PIN_INPUT = MobileBy.id("pinEntryConfirmPin"); //INPUT CONFIRM
    By CHANGE_FINISH_CONFIRM_BUTTON = MobileBy.id("btnPinFinish");
}

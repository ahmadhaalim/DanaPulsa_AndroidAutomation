package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface ForgotPinPageLocator {
    By FORGOT_PIN_OTP_LABEL = MobileBy.id("tvOtpConfirmLabel");
    By PHONENUMBER_OTP_LABEL = MobileBy.id("tvOtpConfirmPhone");
    By OTP_INPUT = MobileBy.id("otpPIN"); //INPUT OTP
    By RESEND_LABEL = MobileBy.id("tvResendOtpLabel");
    By RESEND_BUTTON = MobileBy.id("btnResendOtp");
    By NEXT_BUTTON = MobileBy.id("btnPinNext");
    By FORGOT_PIN_TITLE = MobileBy.id("tvActivityTitle");


    By NEW_PIN_LABEL = MobileBy.id("tvPinLabel");
    By NEW_PIN_INPUT = MobileBy.id("pinEntryNewPin"); //INPUT NEW PIN
    By BACK_BUTTON = MobileBy.id("btnPinBack");
    By NEW_PIN_WARNING = MobileBy.id(""); //KOSONG

    By CONFIRM_PIN_LABEL = MobileBy.id("tvPinConfirmLabel");
    By CONFIRM_PIN_INPUT = MobileBy.id("pinEntryConfirmPin"); //INPUT CONFIRM
    By FINISH_CONFIRM_BUTTON = MobileBy.id("btnPinFinish");
    By CONFIRM_PIN_WARNING = MobileBy.id(""); //KOSONG

}

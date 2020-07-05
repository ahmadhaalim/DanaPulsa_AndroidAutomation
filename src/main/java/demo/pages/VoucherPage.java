package demo.pages;

import demo.locator.VoucherPageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class VoucherPage implements VoucherPageLocator {

    public boolean voucherFound(String voucherValue) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        boolean found = false;
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VOUCHER_NAME));
            List<AndroidElement> voucherNames = androidDriver.findElements(VOUCHER_NAME);
            for (AndroidElement voucherName : voucherNames) {
                if (voucherName.getText().contains(voucherValue)) {
                    found = true;
                    break;
                }
            }
        } catch (TimeoutException ignore) { }

        return found;
    }
}

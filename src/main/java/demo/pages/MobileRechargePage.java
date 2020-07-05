package demo.pages;

import demo.locator.MobileRechargePageLocator;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.AndroidPageObject;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class MobileRechargePage extends AndroidPageObject implements MobileRechargePageLocator {

    public void inputPhoneNumber(String rechargedNumber) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) { }
        clickOn(EDIT_PHONE_NUMBER);
        androidDriver.getKeyboard().sendKeys(rechargedNumber);
        androidDriver.hideKeyboard();
    }

    public void chooseNominal(String nominal, String price) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) { }

        WebElement chosenNominal = androidDriver
                .findElement(By.xpath("//androidx.cardview.widget.CardView//android.widget.TextView[@text='"+nominal+"']"));
        List<AndroidElement> pulsaPrice = androidDriver.findElements(PULSA_PRICE);

        for (AndroidElement p : pulsaPrice) {
            String txPrice = p.getText();
            txPrice = txPrice.replaceAll("\\D+","");
            if (txPrice.equals(price) && chosenNominal.isDisplayed()) {
                p.click();
                break;
            }
        }
    }
}

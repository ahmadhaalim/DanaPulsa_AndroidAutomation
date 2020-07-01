package deviceutilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class AndroidDeviceUtilities {

    /**
     * Perform swipe up on the device screen
     */
    public void swipeUp() {
        Dimension screenSize = androidDriver.manage().window().getSize();
        int fromX = (int) (screenSize.getWidth() * 0.5);
        int fromY = screenSize.getHeight() - 100;
        int toX = (int) (screenSize.getWidth() * 0.5);
        int toY = 100;
        TouchAction action = new TouchAction(androidDriver);
        action.press(PointOption.point(fromX, fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
    }

    /**
     * Perform tap on center of the device screen
     */
    public void tapOnCenter() {
        Dimension screenSize = androidDriver.manage().window().getSize();
        int centerX = (int) (screenSize.getWidth() * 0.5);
        int centerY = (int) (screenSize.getHeight() * 0.5);
        TouchAction action = new TouchAction(androidDriver);
        action.tap(PointOption.point(centerX, centerY)).perform();
    }

    /**
     * Perform turn on/off wifi and data
     */
    public void turnWifiAndData() {
        androidDriver.toggleData();
        try {
            androidDriver.openNotifications();
            androidDriver.findElement(By.xpath("//android.widget.Switch[contains(@content-desc, 'Wi-Fi,')]")).click();
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (NoSuchElementException ignore) {
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}

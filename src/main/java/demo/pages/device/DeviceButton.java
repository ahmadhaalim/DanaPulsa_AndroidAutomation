package demo.pages.device;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class DeviceButton {
    public void pressDeviceBack() {
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void pressDeviceHome(){
        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void pressDeviceRecent(){
        androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    }

    public void tapCenter(){
        Dimension screenSize = androidDriver.manage().window().getSize();
        int centerX = (int) (screenSize.getWidth() * 0.5);
        int centerY = (int) (screenSize.getHeight() * 0.5);
        TouchAction action = new TouchAction(androidDriver);
        action.tap(PointOption.point(centerX, centerY)).perform();
    }

    public void pressLockDevice() {
        androidDriver.lockDevice();
    }

    public void pressUnlockDevice() throws InterruptedException {
        androidDriver.unlockDevice();
        Thread.sleep(4000);
    }

    public void closeReopenApp(){
        try {
            androidDriver.runAppInBackground(Duration.ofSeconds(5));
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void switchInternet() throws InterruptedException {
//        ConnectionState state = AndroidDriverInstance.androidDriver.setConnection(new ConnectionStateBuilder()
//                .withDataDisabled().withWiFiDisabled().build());
        Thread.sleep(3000);
        androidDriver.toggleData();
        Thread.sleep(4000);
//        androidDriver.toggleWifi();
    }

}

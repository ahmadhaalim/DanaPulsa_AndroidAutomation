package demo.pages.device;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.time.Duration;

public class DeviceButton {
    public void pressDeviceBack() {
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void pressLockDevice() {
        AndroidDriverInstance.androidDriver.lockDevice();
    }

    public void pressUnlockDevice() {
        AndroidDriverInstance.androidDriver.unlockDevice();
    }

    public void pressHomeButton() throws InterruptedException {
        try {
            AndroidDriverInstance.androidDriver.runAppInBackground(Duration.ofSeconds(5));
        }catch (Exception e){
            System.out.println(e);
        }
        Thread.sleep(5000);
    }


    public void turnInternetOff() throws InterruptedException {
//        ConnectionState state = AndroidDriverInstance.androidDriver.setConnection(new ConnectionStateBuilder()
//                .withDataDisabled().withWiFiDisabled().build());
        Thread.sleep(3000);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }
    public void turnInternetOn() throws InterruptedException {
        Thread.sleep(3000);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }
}

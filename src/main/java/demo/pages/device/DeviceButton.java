package demo.pages.device;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.time.Duration;

public class DeviceButton {
    public void pressDeviceBack() {
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void pressDeviceHome(){
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void pressDeviceRecent(){
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    }

    public void tapCenter(){
        TouchAction touch = new TouchAction(AndroidDriverInstance.androidDriver);

    }

    public void pressLockDevice() {
        AndroidDriverInstance.androidDriver.lockDevice();
    }

    public void pressUnlockDevice() {
        AndroidDriverInstance.androidDriver.unlockDevice();
    }

    public void pressHomeButton(){
        try {
            AndroidDriverInstance.androidDriver.runAppInBackground(Duration.ofSeconds(5));
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void switchInternet() throws InterruptedException {
//        ConnectionState state = AndroidDriverInstance.androidDriver.setConnection(new ConnectionStateBuilder()
//                .withDataDisabled().withWiFiDisabled().build());
        Thread.sleep(3000);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

}

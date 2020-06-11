package demo.pages.device;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

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

    public void turnInternetOff(){
        ConnectionState state = AndroidDriverInstance.androidDriver.setConnection(new ConnectionStateBuilder()
                .withDataDisabled().withWiFiDisabled().build());
    }
}

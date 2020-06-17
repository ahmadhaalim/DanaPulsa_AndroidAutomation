package deviceutilities;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.time.Duration;

public class AndroidDeviceUtilities {

    public void toggleWifi(){
        AndroidDriverInstance.androidDriver.toggleWifi();
    }
    public void toggleData(){
        AndroidDriverInstance.androidDriver.toggleData();
    }
    public void pressDeviceHomeButton(){
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
    public void pressDeviceBackButton(){
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void lockDevice(){
        AndroidDriverInstance.androidDriver.lockDevice();
    }
    public void unlockDevice(){
        AndroidDriverInstance.androidDriver.unlockDevice();
    }
    public void runAppInBackground() throws InterruptedException {
        try {
            AndroidDriverInstance.androidDriver.runAppInBackground(Duration.ofSeconds(5));
        } catch (Exception e){
            System.out.println(e);
        }
        Thread.sleep(5000);
    }

}
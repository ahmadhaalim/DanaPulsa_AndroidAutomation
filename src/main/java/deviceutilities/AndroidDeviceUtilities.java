package deviceutilities;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static demo.driver.AndroidDriverInstance.androidDriver;

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
    public void unlockDevice() throws InterruptedException {
        AndroidDriverInstance.androidDriver.lockDevice();
        Thread.sleep(3000);
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

    public void reloadScreen() throws InterruptedException {
        Thread.sleep(3000);
        TouchAction touch = new TouchAction(androidDriver);
        //Change the coordinate according your screen resolution (center of it)
        touch.press(PointOption.point(500,500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(500,1000)).release().perform();
    }

    public String setAndGetClipboardData(String text){
        ((HasClipboard)AndroidDriverInstance.androidDriver).setClipboardText(text);
        return AndroidDriverInstance.androidDriver.getClipboardText();
    }

}

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
        //Pixel 3 Xl = 400,300 - 400, 600
        //Nexus S = 200,200 - 200,400
        //Pixel 2= 500, 500 - 500,900
        touch.press(PointOption.point(500,500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(500,900)).release().perform();
    }

    public void swipeLeft() throws InterruptedException {
        Thread.sleep(3000);
        TouchAction touch = new TouchAction(androidDriver);
        //Change the coordinate according your screen resolution (center of it)
        //pixel 3 xl = 1000,1200 - 100,1200
        //nexus s = 400,100 - 100, 400
        touch.press(PointOption.point(1000,1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(100,1200)).release().perform();
    }

    public void swipeRight() throws InterruptedException {
        Thread.sleep(3000);
        TouchAction touch = new TouchAction(androidDriver);
        //Change the coordinate according your screen resolution (center of it)
        //pixel 3 xl = 100,1200 - 1000,1200
        //nexus s = 100,400 - 400,400
        touch.press(PointOption.point(100,1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(1000,1200)).release().perform();
    }

    public String setAndGetClipboardData(String text){
        ((HasClipboard)AndroidDriverInstance.androidDriver).setClipboardText(text);
        return AndroidDriverInstance.androidDriver.getClipboardText();
    }

}

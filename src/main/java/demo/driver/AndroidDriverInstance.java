package demo.driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverInstance {

    public static AndroidDriver<AndroidElement> androidDriver;

    public static void initialize() {
        String appiumUrl = "http://127.0.0.1:4723/wd/hub/";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "device");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("newCommandTimeout", 120);
        caps.setCapability("app",
                System.getProperty("user.dir") + File.separator + "APP" + File.separator + "DANA-Pulsa-1.0.2-develop-debug.apk");
        caps.setCapability("automationName", "UiAutomator2");
    //    caps.setCapability("appPackage", "id.dana.apprentech.danapulsa.develop");
    //    caps.setCapability("appActivity", "id.dana.apprentech.danapulsa.ui.splash.SplashActivity");
        caps.setCapability("skipDeviceInitialization", true);
        caps.setCapability("skipServerInstallation", true);
        try {
            androidDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<AndroidElement> getWebDriver() {
        if (androidDriver == null) {
            initialize();
        }
        return androidDriver;
    }

    public static void quit() {
        androidDriver.quit();
    }

}

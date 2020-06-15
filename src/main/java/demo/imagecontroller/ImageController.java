package demo.imagecontroller;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import pageobjects.AndroidPageObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.UUID;

import static org.bytedeco.javacpp.lept.pixRead;

public class ImageController extends AndroidPageObject {
    public void teslockunlock() throws InterruptedException {
        AndroidDriverInstance.androidDriver.lockDevice();
        Thread.sleep(5000);
        AndroidDriverInstance.androidDriver.unlockDevice();
        Thread.sleep(5000);
    }

    public void teshomeopen() throws InterruptedException {

        Thread.sleep(5000);


        Thread.sleep(5000);
        try {
            AndroidDriverInstance.androidDriver.runAppInBackground(Duration.ofSeconds(5));
        } catch (Exception e) {
            System.out.println(e);
        }
        Thread.sleep(5000);
    }

    public void tesdeviceback() throws InterruptedException {
        Thread.sleep(5000);
        AndroidDriverInstance.androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    Path getResource(String fileName) throws URISyntaxException {
        URL refImgUrl = getClass().getClassLoader().getResource(fileName);
        return Paths.get(refImgUrl.toURI()).toFile().toPath();
    }

    private String getResourceB64(String fileName) throws URISyntaxException, IOException {
        Path refImgPath = getResource(fileName);
        System.out.println(refImgPath);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgPath));
    }

    String getReferenceImageB64(String fileName) throws URISyntaxException, IOException {
        return getResourceB64("images/" + fileName);
    }

    public boolean checkIfWarningDisplayed(String filename) throws IOException, URISyntaxException, InterruptedException {
        String display = getReferenceImageB64(filename);
        boolean settingsVisible = false;
        int count = 0, maxCount = 20;
        Thread.sleep(10000);
        while (!settingsVisible && count < maxCount) {
            count += 1;
            try {
                return AndroidDriverInstance.androidDriver.findElementsByImage(display).size() > 0;
            } catch (TimeoutException skip) {
                continue;
            }
        }
        return false;
    }

//    public void getTextByTesseract() throws IOException {
//        System.out.println("Capturing the snapshot of the page ");
//        File srcFiler=((TakesScreenshot)AndroidDriverInstance.androidDriver).getScreenshotAs(OutputType.FILE);
//        System.out.println(System.getProperty("user.dir") + File.separator + "src" + File.separator
//                + "test" + File.separator + "resources" + File.separator + "validation");
//        FileUtils.copyFile(srcFiler, new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
//            + "test" + File.separator + "resources" + File.separator + "validation"));
////        BytePointer outText;
////        tesseract.TessBaseAPI tessBaseAPI = new tesseract.TessBaseAPI();
////        if (tessBaseAPI.Init(".", "ENG") != 0) {
////            System.err.println("Could not initialize tesseract.");
////            System.exit(1);
////
////            lept.PIX image = pixRead(filePath+"\\toastmessage1.png");
////            tessBaseAPI.SetImage(image);
//        }
//        String text = OCR(image(driver));
//        String Text = Certify(driver);
//        System.out.println(text);
//    }
//
//    public static String image(AppiumDriver<MobileElement> driver)
//    {
//        File targetFile = null;
//        try{
//            File scrfile = driver.getScreenshotAs(OutputType.FILE);
//            String filename = UUID.randomUUID().toString();
//            targetFile = new File("./screenshots"+ filename + ".png");
//            FileUtils.copyFile(scrfile, targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return targetFile.toString();
//    }
//
//    public static String OCR(String ImagePath){
//        String result = null;
//        File imageFile = new File(ImagePath);
//        tesseract.Tesseract instance = new tesseract.Tesseract();
//        try {
//            result = instance.
//        }
//    }

}

package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class AndroidPageObject {
    private By id;

    /**
     * Perform action to click button or clickable element,
     * will wait until the element is enabled.
     * @param id locator of element
     */
    public void clickOn(By id) {
        waitUntilEnabled(id);
        AndroidElement button = androidDriver.findElement(id);
        button.click();
    }

    /**
     * Perform type action of input field elements,
     * will wait until element is displayed.
     * @param id locator of element
     * @param text user input text
     */
    public void typeON(By id, String text) {
        waitUntilDisplayed(id);
        AndroidElement field = androidDriver.findElement(id);
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Perform wait condition until the element is presented.
     * @param id locator of element
     */
    public void waitUntilDisplayed(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        element.isDisplayed();
    }

    /**
     * Perform waiting condition untill the element is available.
     * @param id locator of element
     */
    public void waitUntilEnabled(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        element.isEnabled();
    }

    /**
     * Perform checking if element status is displayed and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfDisplayed(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isDisplayed();
    }

    /**
     * Perform checking if element status is enabled and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfEnabled(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isEnabled();
    }

    /**
     * Perform checking if toast is appeared and returning true condition
     * @param id locator of element
     * @return return condition
     */
    public String checkToast(By id) {
        WebElement toast = androidDriver.findElement(id);
        return toast.getAttribute("name");
    }

    public Path getResource(String fileName) throws URISyntaxException {
        URL refImgUrl = getClass().getClassLoader().getResource(fileName);
        return Paths.get(refImgUrl.toURI()).toFile().toPath();
    }

    public String getResourceB64(String fileName) throws URISyntaxException, IOException {
        Path refImgPath = getResource(fileName);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgPath));
    }

    public String getReferenceImageB64(String fileName) throws URISyntaxException, IOException {
        return getResourceB64("images/" + fileName);
    }

    public boolean checkElementByImage(String imageReference) {
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.95);
        boolean visible = false;
        int count = 0, maxCount = 3;
        while (!visible && count < maxCount) {
            count += 1;
            try {
                androidDriver.findElement(MobileBy.image(imageReference));
                visible = true;
            } catch (NoSuchElementException ign) {
                System.out.println("element by image not found");
            }
        }
        return visible;
    }

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

    public void tapOnCenter() {
        Dimension screenSize = androidDriver.manage().window().getSize();
        int centerX = (int) (screenSize.getWidth() * 0.5);
        int centerY = (int) (screenSize.getHeight() * 0.5);
        TouchAction action = new TouchAction(androidDriver);
        action.tap(PointOption.point(centerX, centerY)).perform();
    }

    public void pressHoldOnElement(WebElement element) {
        TouchAction action = new TouchAction(androidDriver);
        action.longPress(ElementOption.element(element))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .release()
                .perform();
    }

    public void pasteToField(WebElement inputField) {
        TouchAction action = new TouchAction(androidDriver);
//        action.press(PointOption.point((int) (inputField.getSize().getWidth() * 0.5 + 30), inputField.getLocation().y - 30));
        action.press(PointOption.point(inputField.getLocation().x + 30, inputField.getLocation().y - 30))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .release()
                .perform();
    }

//    public boolean checkIfToastDisplayed(By id) {
//        WebElement toast = androidDriver.findElement(id);
//        return toast.isDisplayed();
//    }
}

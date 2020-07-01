package pageobjects;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidMobileCommandHelper;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import javafx.scene.input.TouchEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class AndroidPageObject {
    private By id;
    private static String REGEX_1 = "Rp";
    private static String REGEX_2 = "\\.";
    private static String REPLACE = "";

    Pattern p1 = Pattern.compile(REGEX_1);
    Pattern p2 = Pattern.compile(REGEX_2);

    /**
     * Perform action to click button or clickable element,
     * will wait until the element is enabled.
     *
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
     *
     * @param id   locator of element
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
     *
     * @param id locator of element
     */
    public boolean waitUntilDisplayed(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        return element.isDisplayed();
    }

    /**
     * Perform waiting condition until the element is available.
     *
     * @param id locator of element
     */
    public boolean waitUntilEnabled(By id) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(id));
        return element.isEnabled();
    }

    /**
     * Perform checking if element status is displayed and returning true condition
     *
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfDisplayed(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isDisplayed();
    }

    /**
     * Perform checking if element status is enabled and returning true condition
     *
     * @param id locator of element
     * @return return condition
     */
    public boolean checkIfEnabled(By id) {
        WebElement element = androidDriver.findElement(id);
        return element.isEnabled();
    }

    /**
     * Perform checking if toast is appeared and returning true condition
     *
     * @param id locator of element
     * @return return condition
     */
    public String checkToast(By id) {
        WebElement toast = androidDriver.findElement(id);
        return toast.getAttribute("name");
    }

    /**
     *
     * @param name string inside locator
     * @param locator locator where the element is
     */
    public void multipleID(String name, By locator) {
        List<AndroidElement> filters = androidDriver.findElements(locator);
        for (AndroidElement filter : filters) {
            if (filter.getText().contains(name)) {
                filter.click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param locator locator that want to be checked
     * @return return the size of locator that appeared
     */
    public boolean checkElement(By locator) {
        List<AndroidElement> elements = androidDriver.findElements(locator);
        return elements.size() > 0;
    }

    public int toInteger(By locator){
        String element_1 = androidDriver.findElement(locator).getText();

        Matcher m1 = p1.matcher(element_1);
        String element_2 = m1.replaceAll(REPLACE);
        Matcher m2 = p2.matcher(element_2);
        String element_3 = m2.replaceAll(REPLACE);
        return Integer.parseInt(element_3);

    }
//    public boolean checkIfToastDisplayed(By id) {
//        WebElement toast = androidDriver.findElement(id);
//        return toast.isDisplayed();
//    }
}

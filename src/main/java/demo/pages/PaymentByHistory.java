package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentByHistory {
    public static boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement signInLabel = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("alreadySignInTextView")));
        return signInLabel.isDisplayed();
    }
}

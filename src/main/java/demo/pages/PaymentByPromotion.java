package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AndroidPageObject;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class PaymentByPromotion {
    AndroidPageObject pageObject = new AndroidPageObject();

    public static boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement signInLabel = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("alreadySignInTextView")));
        return signInLabel.isDisplayed();
    }
}


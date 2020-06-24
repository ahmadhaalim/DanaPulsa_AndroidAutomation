package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.GeneralPage;
import demo.pages.SignInPage;
import deviceutilities.AndroidDeviceUtilities;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    GeneralPage generalPage = new GeneralPage();
    SignInPage signInPage = new SignInPage();

    @When("User click device home button")
    public void userClickDeviceHomeButton() {
        androidDeviceUtilities.pressDeviceHomeButton();
    }
    @When("User click device back button")
    public void userClickDeviceBackButton() {
        androidDeviceUtilities.pressDeviceBackButton();
    }
    @When("User open the app after running in the background for a moment")
    public void userOpenTheAppAfterRunningInTheBackgroundForAMoment() throws InterruptedException {
        androidDeviceUtilities.runAppInBackground();
    }

    @When("User tap {string} menu button while internet is {string}")
    public void userTapMenuButton(String menu, String state) {
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleData();
            AndroidDriverInstance.androidDriver.toggleWifi();
        }
        if(menu.equalsIgnoreCase("home")){
            generalPage.clickHomeButton();
        } else if(menu.equalsIgnoreCase("history")){
            generalPage.clickHistoryButton();
        } else if(menu.equalsIgnoreCase("voucher")) {
            generalPage.clickVoucherButton();
        } else if(menu.equalsIgnoreCase("profile")) {
            generalPage.clickProfileButton();
        }
    }

    @When("User perform action {string} while on {string} screen")
    public void userPerformActionWhileOnScreen(String action, String screeName) throws InterruptedException {
        if(action.equalsIgnoreCase("tap back button")){
            generalPage.clickBackButton();
        } else if(action.equalsIgnoreCase("tap device back button")) {
            androidDeviceUtilities.pressDeviceBackButton();
        } else if(action.equalsIgnoreCase("reopen app after in the background")) {
            androidDeviceUtilities.runAppInBackground();
        } else if(action.equalsIgnoreCase("unlock the device after being unlocked")) {
            androidDeviceUtilities.unlockDevice();
        }
    }
}

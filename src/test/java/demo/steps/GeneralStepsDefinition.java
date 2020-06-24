package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.*;
import deviceutilities.AndroidDeviceUtilities;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    GeneralPage generalPage = new GeneralPage();
    ForgotPinPage forgotPinPage = new ForgotPinPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    SignInPage signInPage = new SignInPage();
    SignInInputPinPage signInInputPinPage = new SignInInputPinPage();

    @When("User click device home button")
    public void userClickDeviceHomeButton() {
        androidDeviceUtilities.pressDeviceHomeButton();
    }
    @When("User click device back button")
    public void userClickDeviceBackButton() {
        androidDeviceUtilities.pressDeviceBackButton();
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

    @Then("User see toast message {string}")
    public void userSeeToastMessage(String expected) {
        String actual = generalPage.getToastMessage();
        Assert.assertEquals(expected, actual);
        androidDeviceUtilities.toggleWifi();
        androidDeviceUtilities.toggleData();
    }

    @Then("User directed to {string} screen")
    public void userDirectedToScreen(String screenName) throws InterruptedException {
        if(screenName.equalsIgnoreCase("sign in")){
            Assert.assertTrue(signInPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("input pin")){
            Assert.assertTrue(signInInputPinPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("forgot pin")) {
            Assert.assertTrue(forgotPinPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("home")) {
            Assert.assertTrue(homePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("profile")) {
            Assert.assertTrue(profilePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("device home")){
            String appId = AndroidDriverInstance.androidDriver.getCurrentPackage();
            Assert.assertEquals(AndroidDriverInstance.androidDriver.queryAppState(appId), ApplicationState.RUNNING_IN_BACKGROUND);
        }
        Thread.sleep(5000);
    }
}

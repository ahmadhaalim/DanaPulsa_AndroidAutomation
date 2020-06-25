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
    SignUpPage signUpPage = new SignUpPage();
    SignInInputPinPage signInInputPinPage = new SignInInputPinPage();
    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    PromotionListPage promotionListPage = new PromotionListPage();
    PromotionDetailPage promotionDetailPage = new PromotionDetailPage();

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

    @When("User perform action {string}")
    public void userPerformActionWhileOnScreen(String action) throws InterruptedException {
        if(action.equalsIgnoreCase("tap back button")){
            generalPage.clickBackButton();
        } else if(action.equalsIgnoreCase("tap device back button")) {
            androidDeviceUtilities.pressDeviceBackButton();
        } else if(action.equalsIgnoreCase("reopen app after in the background")) {
            androidDeviceUtilities.runAppInBackground();
        } else if(action.equalsIgnoreCase("unlock the device after being unlocked")) {
            androidDeviceUtilities.unlockDevice();
        } else if(action.equalsIgnoreCase("hold down and release")) {
            androidDeviceUtilities.reloadScreen();
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
        } else if(screenName.equalsIgnoreCase("sign up")) {
            Assert.assertTrue(signUpPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("mobile recharge")) {
            Assert.assertTrue(mobileRechargePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("promotion list")) {
            Assert.assertTrue(promotionListPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("promotion detail")) {
            Assert.assertTrue(promotionDetailPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("device home")){
            String appId = AndroidDriverInstance.androidDriver.getCurrentPackage();
            Assert.assertEquals(AndroidDriverInstance.androidDriver.queryAppState(appId), ApplicationState.RUNNING_IN_BACKGROUND);
        }
        Thread.sleep(5000);
    }

    @When("User tap ok button on warning dialog box")
    public void userTapOkButtonOnWarningDialogBox() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(generalPage.waitUntillErrorDialogBoxDisplayed());
        generalPage.clickOkButton();
    }
}

package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.*;
import deviceutilities.AndroidDeviceUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    GeneralPage generalPage = new GeneralPage();

    @When("User tap {string} menu button while internet is {string}")
    public void userTapMenuButton(String menu, String state) {
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleData();
            //AndroidDriverInstance.androidDriver.toggleWifi();
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
        } else if(action.equalsIgnoreCase("swipe left and right")) {
            androidDeviceUtilities.swipeLeft();
            Thread.sleep(3000);
            androidDeviceUtilities.swipeRight();
        }
    }

    @Then("User see toast message {string}")
    public void userSeeToastMessage(String expected) {
        String actual = generalPage.getToastMessage();
        Assert.assertEquals(expected, actual);
        //androidDeviceUtilities.toggleWifi();
        androidDeviceUtilities.toggleData();
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

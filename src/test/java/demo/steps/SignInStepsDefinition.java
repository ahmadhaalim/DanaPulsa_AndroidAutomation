package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.*;
import deviceutilities.AndroidDeviceUtilities;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInStepsDefinition {

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    SignInPage signInPage = new SignInPage();
    SignInInputPinPage signInInputPinPage = new SignInInputPinPage();
    ForgotPinPage forgotPinPage = new ForgotPinPage();
    HomePage homePage = new HomePage();
    GeneralPage generalPage = new GeneralPage();

    @Then("User directed to {string} screen")
    public void userDirectedToScreen(String screenName) throws InterruptedException {
        Thread.sleep(5000);
        if(screenName.equalsIgnoreCase("sign in")){
            Assert.assertTrue(signInPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("input pin")){
            Assert.assertTrue(signInInputPinPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("forgot pin")) {
            Assert.assertTrue(forgotPinPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("home")) {
            Assert.assertTrue(homePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("device home")){
            String appId = AndroidDriverInstance.androidDriver.getCurrentPackage();
            Assert.assertEquals( ApplicationState.RUNNING_IN_FOREGROUND, AndroidDriverInstance.androidDriver.queryAppState(appId));
        }
    }

    @When("User input phone number {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        signInPage.inputPhoneNumber(phoneNumber);
    }

    @When("User tap sign up button")
    public void userTapSignUpButton() {
        signInPage.clickSignUpButton();
    }

    @When("User tap forgot pin text")
    public void userTapForgotPinText() {
        signInInputPinPage.clickForgotPinButton();
    }

    @When("User input pin {string} while internet is {string}")
    public void userInputPinWhileInternetIs(String pin, String state) throws InterruptedException {
        if(state.equalsIgnoreCase("on")){
            signInInputPinPage.inputPin(pin);
        }
        else if(state.equalsIgnoreCase("off")){
            androidDeviceUtilities.toggleData();
            //androidDeviceUtilities.toggleWifi();
            Thread.sleep(3000);
            signInInputPinPage.inputPin(pin);
        }
    }

    @Then("User see error message text {string} on sign in screen")
    public void userSeeErrorMessageTextOnSignInScreen(String expected) {
        String actual = generalPage.getErrorMessageText();
        Assert.assertEquals(expected, actual);
    }

    @And("User see sign button disabled")
    public void userSeeSignSignButtonDisabled() {
        Assert.assertFalse(signInPage.checkSignButton());
    }

    @And("User tap sign in button while internet is {string}")
    public void userTapSignInButtonWhileInternetIs(String keyword) throws InterruptedException {
        if (keyword.equalsIgnoreCase("off")) {
            androidDeviceUtilities.toggleData();
            //androidDeviceUtilities.toggleWifi();
        }
        Thread.sleep(3000);
        signInPage.clickSignInButton();
    }

    @Then("User see warning message pop up {string}")
    public void userSeeWarningMessagePopUpOnScreen(String expected) throws InterruptedException {
        String actual = generalPage.getWarningMessagePopUpText();
        Assert.assertEquals(expected, actual);
        generalPage.clickWarningMessagePopUpOkButton();
        if(expected.equalsIgnoreCase("Connection Error")) {
            //androidDeviceUtilities.toggleWifi();
            androidDeviceUtilities.toggleData();
        }
    }
}

package demo.steps;

import demo.pages.*;
import deviceutilities.AndroidDeviceUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInStepsDefinition extends AndroidDeviceUtilities {

    SignInPage signInPage = new SignInPage();
    SignInInputPinPage signInInputPinPage = new SignInInputPinPage();
    ForgotPinPage forgotPinPage = new ForgotPinPage();

    @Then("User directed to sign in screen")
    public void userDirectedToSignInScreen() {
        Assert.assertTrue(signInPage.isOnPage());
    }

    @Given("User is on sign in page")
    public void userIsOnSignInPage() {
        Assert.assertTrue(signInPage.isOnPage());
    }

    @When("User input phone number {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        signInPage.inputPhoneNumber(phoneNumber);
    }

    @And("User click sign in button")
    public void userClickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("User directed to input pin screen")
    public void userDirectedToInputPinScreen() {
        Assert.assertTrue(signInInputPinPage.isOnPage());
    }

    @When("User input pin {string}")
    public void userInputPin(String pin) {
        signInInputPinPage.inputPin(pin);
    }

    @Then("User see warning message {string} on input pin screen")
    public void userSeeWarningMessageOnInputPinScreen(String errorMessageExpectation) {
        signInInputPinPage.checkErrorDialog();
        String errorMessage = signInInputPinPage.getErrorDialogText();
        Assert.assertEquals(errorMessageExpectation, errorMessage);
        signInInputPinPage.clickErrorDialogOkButton();
    }

    @Then("User see warning message {string} on sign in page")
    public void userSeeWarningMessageOnSignInPage(String expected) {
        signInPage.checkErrorDialog();
        String actual = signInPage.getErrorDialogText();
        Assert.assertEquals(expected, actual);
        signInPage.clickErrorDialogOkButton();
        toggleWifi();
        toggleData();
    }

    @When("User click sign up button")
    public void userClickSignUpButton() {
        signInPage.clickSignUpButton();
    }

    @When("User click forgot pin text")
    public void userClickForgotPinText() {
        signInInputPinPage.clickForgotPinButton();
    }

    @Then("User directed to forgot pin screen")
    public void userDirectedToForgotPinScreen() {
        forgotPinPage.isOnPage();
    }

    @When("User click back button on forgot pin screen")
    public void userClickBackButtonOnForgotPinScreen() {
        forgotPinPage.clickBackButton();
    }

    @When("User click back button on input pin screen")
    public void userClickBackButtonOnInputPinScreen() {
        signInInputPinPage.clickBackButton();
    }

    @When("User input pin {string} while internet is off")
    public void userInputPinWhileInternetIsOff(String pin) throws InterruptedException {
        toggleData();
        toggleWifi();
        Thread.sleep(3000);
        signInInputPinPage.inputPin(pin);
    }

    @Then("User directed to device home from sign in screen")
    public void userDirectedToDeviceHomeFromSignInScreen() {
        Assert.assertFalse(signInPage.isOnPage());
    }
}

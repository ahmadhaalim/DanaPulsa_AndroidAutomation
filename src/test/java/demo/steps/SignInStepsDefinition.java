package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInStepsDefinition {

    SignInPage signInPage = new SignInPage();
    SignInInputPinPage signInInputPinPage = new SignInInputPinPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    ForgotPinPage forgotPinPage = new ForgotPinPage();
    SignUpPage signUpPage = new SignUpPage();

    String phoneNumberFromInput = "";

    @Given("User is on sign in page")
    public void userIsOnSignInPage() {
        signInPage.isOnPage();
    }

    @When("User input phone number {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        signInPage.inputPhoneNumber(phoneNumber);
        phoneNumberFromInput = phoneNumber;
    }

    @And("User click sign in button")
    public void userClickSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("User directed to input pin screen")
    public void userDirectedToInputPinScreen() {
        signInInputPinPage.isOnPage();
    }

    @When("User input pin {string}")
    public void userInputPin(String pin) {
        signInInputPinPage.inputPin(pin);
    }

    @Then("User directed to home screen")
    public void userDirectedToHomeScreen() {
        homePage.isOnPage();
    }

    @When("User click profile button")
    public void userClickProfileButton() {
        homePage.clickProfileButton();
    }

    @Then("User directed to profile screen")
    public void userDirectedToProfileScreen() {
        profilePage.isOnPage();
    }

    @And("User see phone number used to signing in")
    public void userSeePhoneNumberUsedToSigningIn() {
        String phoneNumber = profilePage.getPhoneNumber();
        Assert.assertEquals(phoneNumberFromInput,phoneNumber);
    }

    @Then("User see warning message {string} on input pin screen")
    public void userSeeWarningMessageOnInputPinScreen(String errorMessageExpectation) {
        signInInputPinPage.checkErrorDialog();
        String errorMessage = signInInputPinPage.getErrorDialogText();
        Assert.assertEquals(errorMessageExpectation, errorMessage);
        signInInputPinPage.clickErrorDialogOkButton();
    }

    @Then("User see warning message {string} on sign in page")
    public void userSeeWarningMessageOnSignInPage(String errorMessageExpectation) {
        signInPage.checkErrorDialog();
        String errorMessage = signInPage.getErrorDialogText();
        Assert.assertEquals(errorMessageExpectation, errorMessage);
        signInPage.clickErrorDialogOkButton();
    }

    @When("User click sign up button")
    public void userClickSignUpButton() {
        signInPage.clickSignUpButton();
    }

    @Then("User directed to sign up screen")
    public void userDirectedToSignUpScreen() {
        signInPage.isOnPage();
    }

    @When("User click back button on sign up screen")
    public void userClickBackButtonOnSignUpScreen() {
        signUpPage.clickBackButton();
    }

    @Then("User directed to sign in screen")
    public void userDirectedToSignInScreen() {
        signInPage.isOnPage();
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

}

package demo.steps;

import demo.pages.nauval.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepsDefinition {
    SignInPage signIn;

    @Given("User is on sign in page")
    public void userIsOnSignInPage() {
        boolean status = signIn.isOnPage();
        Assert.assertTrue(status);
    }

    @When("User input phone number {string}")
    public void userInputPhoneNumber(String number) {
        signIn.inputNumber(number);
        signIn.signInButton();
    }

    @And("User input pin number {string}")
    public void userInputPinNumber(String pin) {
        signIn.inputPIN(pin);
    }
}

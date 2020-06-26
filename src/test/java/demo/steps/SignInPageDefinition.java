package demo.steps;

import demo.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInPageDefinition {

    SignInPage signIn = new SignInPage();

    @Given("User is on sign in page")
    public void userIsOnSignInPage() {
        boolean status_1 = signIn.isOnPage();
        Assert.assertTrue(status_1);

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

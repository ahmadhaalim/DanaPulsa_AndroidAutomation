package demo.steps;

import demo.pages.SignUpPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpStepsDefinition {

    SignUpPage signUpPage = new SignUpPage();

    @Then("User directed to sign up screen")
    public void userDirectedToSignUpScreen() {
        Assert.assertTrue(signUpPage.isOnPage());
    }

    @When("User click back button on sign up screen")
    public void userClickBackButtonOnSignUpScreen() {
        signUpPage.clickBackButton();
    }
}

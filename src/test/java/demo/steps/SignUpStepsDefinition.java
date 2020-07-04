package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SignUpStepsDefinition {

    SignUpFullNamePage signUpFullNamePage = new SignUpFullNamePage();
    SignUpEmailPage signUpEmailPage = new SignUpEmailPage();
    SignUpPhoneNumberPage signUpPhoneNumberPage = new SignUpPhoneNumberPage();
    SignUpCreatePinPage signUpCreatePinPage = new SignUpCreatePinPage();
    SignUpConfirmPinPage signUpConfirmPinPage = new SignUpConfirmPinPage();
    GeneralPage generalPage = new GeneralPage();


    @Then("User directed to sign up screen")
    public void userDirectedToSignUpScreen() {
        Assert.assertTrue(signUpFullNamePage.isOnPage());
    }

    @And("User input {string} on {string} screen")
    public void userInputOnScreen(String input, String screen) {
        switch (screen) {
            case "Full Name":
                signUpFullNamePage.inputFullName(input);
                break;
            case "Email":
                signUpEmailPage.inputEmail(input);
                break;
            case "Phone Number":
                signUpPhoneNumberPage.inputPhoneNumber(input);
                break;
            case "Create PIN":
                signUpCreatePinPage.inputPIN(input);
                break;
            case "Confirm PIN":
                signUpConfirmPinPage.inputConfirmPIN(input);
                break;
            default: break;
        }
    }

    @And("User tap Next button")
    public void userTapNextButton() {
        generalPage.clickSignUpNextButton();
    }

    @And("User tap Finish button")
    public void userTapFinishButton() throws InterruptedException {
        generalPage.clickSignUpFinishButton();
        Thread.sleep(5000);
    }
}

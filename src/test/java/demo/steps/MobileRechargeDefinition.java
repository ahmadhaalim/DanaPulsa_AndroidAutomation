package demo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileRechargeDefinition {
    @Given("User is on homepage")
    public void userIsOnHomepage() {
    }

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {
    }

    @And("User input {int}")
    public void userInputPhoneNumber(int phoneNumber) {
    }

    @And("User choose top up nominal based on {string}")
    public void userChooseTopUpNominalBasedOn(String provider) {
    }

    @And("User see payment detail page")
    public void userSeePaymentDetailPage() {
    }

    @And("User pay the bill")
    public void userPayTheBill() {
    }

    @Then("User see payment success page")
    public void userSeePaymentSuccessPage() {
    }

}
